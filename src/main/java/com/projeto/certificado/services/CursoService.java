package com.projeto.certificado.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.projeto.certificado.models.Curso;
import com.projeto.certificado.models.dto.CursoRequestDto;
import com.projeto.certificado.models.dto.CursoResponseDto;
import com.projeto.certificado.repositorys.CursoRepository;

@org.springframework.stereotype.Service
public class CursoService {

	@Autowired
	private CursoRepository repository;


	public ResponseEntity<CursoResponseDto> criar(CursoRequestDto cursoEntrada) {
        Curso curso = new Curso(cursoEntrada.getNome(), cursoEntrada.getDataInicio(), cursoEntrada.getDataFinal(), cursoEntrada.getProfessor());
        repository.save(curso);
        return new ResponseEntity<>(mapToDto(curso), HttpStatus.CREATED);
    }

	public ResponseEntity<Boolean> alterar(Long id, CursoRequestDto cursoEntrada) {
        Optional<Curso> buscandoCurso = repository.findById(id);
        if (buscandoCurso.isPresent()) {
            Curso curso = buscandoCurso.get();
            curso.setNome(cursoEntrada.getNome());
            curso.setDataInicio(cursoEntrada.getDataInicio());
            curso.setDataFinal(cursoEntrada.getDataFinal());
            curso.setProfessor(cursoEntrada.getProfessor());
            repository.save(curso);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

	public ResponseEntity<CursoResponseDto> pegarUm(Long id) {
        Optional<Curso> buscandoCurso = repository.findById(id);
        return buscandoCurso.map(curso -> new ResponseEntity<>(mapToDto(curso), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

	public ResponseEntity<Boolean> excluir(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

	public ResponseEntity<List<CursoResponseDto>> listar() {
        List<Curso> listaCursos = repository.findAll();
        List<CursoResponseDto> listaSaida = listaCursos.stream().map(this::mapToDto).collect(Collectors.toList());
        return new ResponseEntity<>(listaSaida, HttpStatus.OK);
    }

	private CursoResponseDto mapToDto(Curso curso) {
        return new CursoResponseDto(curso.getId(), curso.getNome(), curso.getDataInicio(), curso.getDataFinal(), curso.getProfessor());
    }

}