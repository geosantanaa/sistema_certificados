package com.projeto.certificado.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.certificado.models.Aluno;
import com.projeto.certificado.models.dto.AlunoRequestDto;
import com.projeto.certificado.models.dto.AlunoResponseDto;
import com.projeto.certificado.repositorys.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

    @Autowired
	private ModelMapper mapper;


	public AlunoResponseDto criar(AlunoRequestDto alunoEntrada) {
        Aluno aluno = mapper.map(alunoEntrada, Aluno.class);
        repository.save(aluno);

        AlunoResponseDto saida = mapper.map(aluno, AlunoResponseDto.class);
        return saida;
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