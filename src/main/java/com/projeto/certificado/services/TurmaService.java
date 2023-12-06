package com.projeto.certificado.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.certificado.models.Turma;
import com.projeto.certificado.models.dto.TurmaRequestDto;
import com.projeto.certificado.models.dto.TurmaResponseDto;
import com.projeto.certificado.repositorys.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repository;

    @Autowired
	private ModelMapper mapper;


	public TurmaResponseDto criar(TurmaRequestDto turmaEntrada) {
        Turma turma = mapper.map(turmaEntrada, Turma.class);
        repository.save(turma);

        TurmaResponseDto saida = mapper.map(turma, TurmaResponseDto.class);
        return saida;
    }

	public boolean excluir(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

	public List<TurmaResponseDto> listar() {
        List<Turma> listaTurmas = repository.findAll();
        return listaTurmas.stream().map(turma -> mapper.map(turma, TurmaResponseDto.class)).collect(Collectors.toList());
    }

}