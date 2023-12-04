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
import com.projeto.certificado.models.Endereco;
import com.projeto.certificado.models.Endereco;
import com.projeto.certificado.models.dto.EnderecoRequestDto;
import com.projeto.certificado.models.dto.EnderecoResponseDto;
import com.projeto.certificado.models.dto.EnderecoRequestDto;
import com.projeto.certificado.repositorys.EnderecoRepository;
import com.projeto.certificado.repositorys.EnderecoRepository;

@org.springframework.stereotype.Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;


	public ResponseEntity<EnderecoResponseDto> criar(EnderecoRequestDto categoriaEntrada) {
        Endereco categoria = new Endereco(categoriaEntrada.getNome(), categoriaEntrada.getDescricao());
        repository.save(categoria);
        return new ResponseEntity<>(mapToDto(categoria), HttpStatus.CREATED);
    }

	public ResponseEntity<Boolean> alterar(Long id, EnderecoRequestDto categoriaEntrada) {
        Optional<Endereco> buscandoEndereco = repository.findById(id);
        if (buscandoEndereco.isPresent()) {
            Endereco categoria = buscandoEndereco.get();
            Endereco.setNome(categoriaEntrada.getNome());
            categoria.setDescricao(categoriaEntrada.getDescricao());
            repository.save(categoria);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

	public ResponseEntity<EnderecoResponseDto> pegarUm(Long id) {
        Optional<Categoria> buscandoCategoria = repository.findById(id);
        return buscandocategoria.map(Categoria -> new ResponseEntity<>(mapToDto(Categoria), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

	public ResponseEntity<Boolean> excluir(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

	public ResponseEntity<List<CategoriaResponseDto>> listar() {
        List<Categoria> listaCategorias = repository.findAll();
        List<CategoriaResponseDto> listaSaida = listaCategorias.stream().map(this::mapToDto).collect(Collectors.toList());
        return new ResponseEntity<>(listaSaida, HttpStatus.OK);
    }

	private CategoriaResponseDto mapToDto(Categoria Categoria) {
        return new CategoriaResponseDto(Categoria.getId(), Categoria.getNome(), Categoria.getDescricao());
    }

}