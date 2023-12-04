package com.example.curiculos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.curiculos.model.Curriculo;
import com.example.curiculos.model.dto.CurriculoEntradaDto;
import com.example.curiculos.model.dto.CurriculoSaidaDto;
import com.example.curiculos.repository.CurriculoRepository;
import com.projeto.certificado.models.Admin;
import com.projeto.certificado.models.dto.AdminRequestDto;
import com.projeto.certificado.models.dto.AdminResponseDto;
import com.projeto.certificado.repositorys.AdminRepository;

@org.springframework.stereotype.Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;


	public ResponseEntity<AlunoResponseDto> criar(AlunoRequestDto alunoEntrada) {
        Aluno aluno = new Aluno(alunoEntrada.getNome(), alunoEntrada.getEmail(), alunoEntrada.getTurma(), alunoEntrada.getCurso(), alunoEntrada.getCertificado());
        repository.save(aluno);
        return new ResponseEntity<>(mapToDto(aluno), HttpStatus.CREATED);
    }

	public ResponseEntity<Boolean> alterar(Long id, AlunoRequestDto alunoEntrada) {
        Optional<Aluno> buscandoAluno = repository.findById(id);
        if (buscandoAluno.isPresent()) {
            Aluno aluno = buscandoAluno.get();
            aluno.setNome(alunoEntrada.getNome());
            aluno.setEmail(alunoEntrada.getEmail());
            aluno.setTurma(alunoEntrada.getTurma());
            aluno.setCurso(alunoEntrada.getCurso());
            aluno.setCertificado(alunoEntrada.getCertificado());
            repository.save(aluno);
            return new ResponseEntity<>(true, HttpStatus.OK);
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