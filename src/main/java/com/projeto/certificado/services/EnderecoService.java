package com.projeto.certificado.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.certificado.models.Endereco;
import com.projeto.certificado.models.dto.EnderecoRequestDto;
import com.projeto.certificado.models.dto.EnderecoResponseDto;
import com.projeto.certificado.repositorys.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;

    @Autowired
	private ModelMapper mapper;


	public EnderecoResponseDto criar(EnderecoRequestDto enderecoEntrada) {
        Endereco endereco = mapper.map(enderecoEntrada, Endereco.class);
        repository.save(endereco);

        EnderecoResponseDto saida = mapper.map(endereco, EnderecoResponseDto.class);
        return saida;
    }

	public boolean alterar(Long id, EnderecoRequestDto enderecoEntrada) {
        Optional<Endereco> buscandoEndereco = repository.findById(id);

        if(buscandoEndereco.isPresent()){
            Endereco endereco = buscandoEndereco.get();
            mapper.map(enderecoEntrada, Endereco.class);
            repository.save(endereco);
            return true;
        }
        return false;
    }

	public EnderecoResponseDto pegarUm(Long id) {
        Optional<Endereco> buscandoEndereco = repository.findById(id);

        if(buscandoEndereco.isPresent()){
            Endereco endereco = buscandoEndereco.get();
            EnderecoResponseDto saida = mapper.map(endereco, EnderecoResponseDto.class);
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

	public List<EnderecoResponseDto> listar() {
        List<Endereco> listaEnderecos = repository.findAll();
        return listaEnderecos.stream().map(endereco -> mapper.map(endereco, EnderecoResponseDto.class)).collect(Collectors.toList());
    }

}