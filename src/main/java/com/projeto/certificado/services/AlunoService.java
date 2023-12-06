package com.projeto.certificado.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.certificado.models.Aluno;
import com.projeto.certificado.models.Certificado;
import com.projeto.certificado.models.Curso;
import com.projeto.certificado.models.Turma;
import com.projeto.certificado.models.dto.AlunoRequestDto;
import com.projeto.certificado.models.dto.AlunoResponseDto;
import com.projeto.certificado.repositorys.AlunoRepository;
import com.projeto.certificado.repositorys.CertificadoRepository;
import com.projeto.certificado.repositorys.CursoRepository;
import com.projeto.certificado.repositorys.TurmaRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

    @Autowired
	private TurmaRepository turmaRepository;

    @Autowired
	private CursoRepository cursoRepository;

    @Autowired
	private CertificadoRepository certificadoRepository;

    @Autowired
	private ModelMapper mapper;


	public AlunoResponseDto criar(AlunoRequestDto alunoEntrada) {
        Aluno aluno = mapper.map(alunoEntrada, Aluno.class);

         Optional<Turma> buscandoTurma = turmaRepository.findById(alunoEntrada.getTurmaId());
        if(buscandoTurma.isPresent()){
            Turma turma = buscandoTurma.get();
            aluno.setTurma(turma);
        }

         Optional<Curso> buscandoCurso = cursoRepository.findById(alunoEntrada.getCursoId());
        if(buscandoCurso.isPresent()){
            Curso curso = buscandoCurso.get();
            aluno.setCurso(curso);
        }

         Optional<Certificado> buscandoCertificado = certificadoRepository.findById(alunoEntrada.getCertificadoId());
        if(buscandoCertificado.isPresent()){
            Certificado certificado = buscandoCertificado.get();
            aluno.setCertificado(certificado);
        }

        Aluno saida = repository.save(aluno);
        return mapper.map(saida, AlunoResponseDto.class);
    }

	public boolean alterar(Long id, AlunoRequestDto alunoEntrada) {
        Optional<Aluno> buscandoAluno = repository.findById(id);

        if(buscandoAluno.isPresent()){
            Aluno aluno = buscandoAluno.get();
            mapper.map(alunoEntrada, Aluno.class);
            repository.save(aluno);
            return true;
        }
        return false;
    }

	public AlunoResponseDto pegarUm(Long id) {
        Optional<Aluno> buscandoAluno = repository.findById(id);

        if(buscandoAluno.isPresent()){
            Aluno aluno = buscandoAluno.get();
            AlunoResponseDto saida = mapper.map(aluno, AlunoResponseDto.class);
            return saida;
        }
        return null;
    }

	public boolean excluir(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

	public List<AlunoResponseDto> listar() {
        List<Aluno> listaAlunos = repository.findAll();
        return listaAlunos.stream().map(aluno -> mapper.map(aluno, AlunoResponseDto.class)).collect(Collectors.toList());
    }

}