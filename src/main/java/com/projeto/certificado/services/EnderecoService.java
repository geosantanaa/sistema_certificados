package com.projeto.certificado.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.projeto.certificado.models.Endereco;
import com.projeto.certificado.models.dto.EnderecoRequestDto;
import com.projeto.certificado.models.dto.EnderecoResponseDto;
import com.projeto.certificado.repositorys.EnderecoRepository;

@org.springframework.stereotype.Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;


	public ResponseEntity<EnderecoResponseDto> criar(EnderecoRequestDto enderecoEntrada) {
        Endereco endereco = new Endereco(enderecoEntrada.getLogradouro(), enderecoEntrada.getNumero(), enderecoEntrada.getBairro(), enderecoEntrada.getCidade());
        repository.save(endereco);
        return new ResponseEntity<>(mapToDto(endereco), HttpStatus.CREATED);
    }

	public ResponseEntity<Boolean> alterar(Long id, EnderecoRequestDto enderecoEntrada) {
        Optional<Endereco> buscandoEndereco = repository.findById(id);
        if (buscandoEndereco.isPresent()) {
            Endereco endereco = buscandoEndereco.get();
            endereco.setLogradouro(enderecoEntrada.getLogradouro());
            endereco.setNumero(enderecoEntrada.getNumero());
            endereco.setBairro(enderecoEntrada.getBairro());
            endereco.setCidade(enderecoEntrada.getCidade());
            repository.save(endereco);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

	public ResponseEntity<EnderecoResponseDto> pegarUm(Long id) {
        Optional<Endereco> buscandoEndereco = repository.findById(id);
        return buscandoEndereco.map(endereco -> new ResponseEntity<>(mapToDto(endereco), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

	public ResponseEntity<Boolean> excluir(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

	public ResponseEntity<List<EnderecoResponseDto>> listar() {
        List<Endereco> listaEnderecos = repository.findAll();
        List<EnderecoResponseDto> listaSaida = listaEnderecos.stream().map(this::mapToDto).collect(Collectors.toList());
        return new ResponseEntity<>(listaSaida, HttpStatus.OK);
    }

	private EnderecoResponseDto mapToDto(Endereco endereco) {
        return new EnderecoResponseDto(endereco.getId(), endereco.getLogradouro(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade());
    }

}