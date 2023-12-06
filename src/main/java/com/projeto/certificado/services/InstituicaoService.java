package com.projeto.certificado.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.certificado.models.Endereco;
import com.projeto.certificado.models.Instituicao;
import com.projeto.certificado.models.dto.InstituicaoRequestDto;
import com.projeto.certificado.models.dto.InstituicaoResponseDto;
import com.projeto.certificado.repositorys.EnderecoRepository;
import com.projeto.certificado.repositorys.InstituicaoRepository;

@Service
public class InstituicaoService {

	@Autowired
	private InstituicaoRepository repository;

    @Autowired
	private EnderecoRepository enderecoRepository;

    @Autowired
	private ModelMapper mapper;


	
    public InstituicaoResponseDto criar(InstituicaoRequestDto instituicaoEntrada) {
        Instituicao instituicao = mapper.map(instituicaoEntrada, Instituicao.class);

        Optional<Endereco> buscandoEndereco = enderecoRepository.findById(instituicaoEntrada.getEnderecoId());
        if(buscandoEndereco.isPresent()){
            Endereco endereco = buscandoEndereco.get();
            instituicao.setEndereco(endereco);
        }

        Instituicao saida = repository.save(instituicao);
        return mapper.map(saida, InstituicaoResponseDto.class);
    }

	public boolean alterar(Long id, InstituicaoRequestDto instituicaoEntrada) {
        if (id == null || id <= 0) {
            return false;
        }
    
        Optional<Instituicao> buscandoInstituicao = repository.findById(id);
    
        if (buscandoInstituicao.isPresent()) {
            Instituicao instituicao = buscandoInstituicao.get();
            
            try {
                mapper.map(instituicaoEntrada, instituicao);
                repository.save(instituicao);
                return true;
            } catch (Exception ex) {
                return false;
            }
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