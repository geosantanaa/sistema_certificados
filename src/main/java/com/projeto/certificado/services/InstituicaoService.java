package com.projeto.certificado.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.certificado.models.Instituicao;
import com.projeto.certificado.models.dto.InstituicaoRequestDto;
import com.projeto.certificado.models.dto.InstituicaoResponseDto;
import com.projeto.certificado.repositorys.InstituicaoRepository;

@Service
public class InstituicaoService {

	@Autowired
	private InstituicaoRepository repository;

    @Autowired
	private ModelMapper mapper;


	public InstituicaoResponseDto criar(InstituicaoRequestDto instituicaoEntrada) {
        Instituicao instituicao = mapper.map(instituicaoEntrada, Instituicao.class);
        repository.save(instituicao);

        InstituicaoResponseDto saida = mapper.map(instituicao, InstituicaoResponseDto.class);
        return saida;
    }

	public boolean alterar(Long id, InstituicaoRequestDto instituicaoEntrada) {
        Optional<Instituicao> buscandoInstituicao = repository.findById(id);

        if(buscandoInstituicao.isPresent()){
            Instituicao instituicao = buscandoInstituicao.get();
            mapper.map(instituicaoEntrada, Instituicao.class);
            repository.save(instituicao);
            return true;
        }
        return false;
    }

	public InstituicaoResponseDto pegarUm(Long id) {
        Optional<Instituicao> buscandoInstituicao = repository.findById(id);

        if(buscandoInstituicao.isPresent()){
            Instituicao instituicao = buscandoInstituicao.get();
            InstituicaoResponseDto saida = mapper.map(instituicao, InstituicaoResponseDto.class);
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

	public List<InstituicaoResponseDto> listar() {
        List<Instituicao> listaInstituicaos = repository.findAll();
        return listaInstituicaos.stream().map(instituicao -> mapper.map(instituicao, InstituicaoResponseDto.class)).collect(Collectors.toList());
    }

}