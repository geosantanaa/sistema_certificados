package com.projeto.certificado.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.certificado.models.Curso;
import com.projeto.certificado.models.dto.CursoRequestDto;
import com.projeto.certificado.models.dto.CursoResponseDto;
import com.projeto.certificado.repositorys.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repository;

    @Autowired
	private ModelMapper mapper;


	public CursoResponseDto criar(CursoRequestDto cursoEntrada) {
        Curso curso = mapper.map(cursoEntrada, Curso.class);
        repository.save(curso);

        CursoResponseDto saida = mapper.map(curso, CursoResponseDto.class);
        return saida;
    }

	public boolean alterar(Long id, CursoRequestDto cursoEntrada) {
        Optional<Curso> buscandoCurso = repository.findById(id);

        if(buscandoCurso.isPresent()){
            Curso curso = buscandoCurso.get();
            mapper.map(cursoEntrada, Curso.class);
            repository.save(curso);
            return true;
        }
        return false;
    }

	public CursoResponseDto pegarUm(Long id) {
        Optional<Curso> buscandoCurso = repository.findById(id);

        if(buscandoCurso.isPresent()){
            Curso curso = buscandoCurso.get();
            CursoResponseDto saida = mapper.map(curso, CursoResponseDto.class);
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

	public List<CursoResponseDto> listar() {
        List<Curso> listaCursos = repository.findAll();
        return listaCursos.stream().map(curso -> mapper.map(curso, CursoResponseDto.class)).collect(Collectors.toList());
    }

}