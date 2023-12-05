package com.projeto.certificado.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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

@org.springframework.stereotype.Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

    @Autowired
	private TurmaRepository turmaRepository;

    @Autowired
	private CursoRepository cursoRepository;

    @Autowired
	private CertificadoRepository certificadoRepository;


	public ResponseEntity<AlunoResponseDto> criar(AlunoRequestDto alunoEntrada) {
        Aluno aluno = new Aluno(alunoEntrada.getNome(), alunoEntrada.getEmail(), alunoEntrada.getTurmaId(), alunoEntrada.getCursoId(), alunoEntrada.getCertificadoId());
        repository.save(aluno);
        return new ResponseEntity<>(mapToDto(aluno), HttpStatus.CREATED);
    }

	public ResponseEntity<Boolean> alterar(Long id, AlunoRequestDto alunoEntrada) {
    Optional<Aluno> buscandoAluno = repository.findById(id);

    if (buscandoAluno.isPresent()) {
        Aluno aluno = buscandoAluno.get();
        aluno.setNome(alunoEntrada.getNome());
        aluno.setEmail(alunoEntrada.getEmail());

        Optional<Turma> turmaOptional = turmaRepository.findById(alunoEntrada.getTurmaId());

        Optional<Curso> cursoOptional = cursoRepository.findById(alunoEntrada.getCursoId());

        Optional<Certificado> certificadoOptional = certificadoRepository.findById(alunoEntrada.getCertificadoId());

        if (turmaOptional.isPresent() && cursoOptional.isPresent() && certificadoOptional.isPresent()) {
            Turma turma = turmaOptional.get();
            Curso curso = cursoOptional.get();
            Certificado certificado = certificadoOptional.get();

            aluno.setTurma(turma);
            aluno.setCurso(curso);
            aluno.setCertificado(certificado);

            repository.save(aluno);

            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
}


	public ResponseEntity<AlunoResponseDto> pegarUm(Long id) {
        Optional<Aluno> buscandoAluno = repository.findById(id);
        return buscandoAluno.map(aluno -> new ResponseEntity<>(mapToDto(aluno), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

	public ResponseEntity<Boolean> excluir(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

	public ResponseEntity<List<AlunoResponseDto>> listar() {
        List<Aluno> listaAlunos = repository.findAll();
        List<AlunoResponseDto> listaSaida = listaAlunos.stream().map(this::mapToDto).collect(Collectors.toList());
        return new ResponseEntity<>(listaSaida, HttpStatus.OK);
    }

	private AlunoResponseDto mapToDto(Aluno aluno) {
        return new AlunoResponseDto(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getTurma(), aluno.getCurso(), aluno.getCertificado());
    }

}