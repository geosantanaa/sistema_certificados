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
import com.projeto.certificado.models.Categoria;
import com.projeto.certificado.models.Categoria;
import com.projeto.certificado.models.dto.CategoriaRequestDto;
import com.projeto.certificado.models.dto.CategoriaResponseDto;
import com.projeto.certificado.models.dto.CategoriaRequestDto;
import com.projeto.certificado.repositorys.CategoriaRepository;
import com.projeto.certificado.repositorys.CategoriaRepository;

@org.springframework.stereotype.Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;


	public ResponseEntity<CategoriaResponseDto> criar(CategoriaRequestDto categoriaEntrada) {
        Categoria categoria = new Categoria(categoriaEntrada.getNome(), categoriaEntrada.getDescricao());
        repository.save(categoria);
        return new ResponseEntity<>(mapToDto(categoria), HttpStatus.CREATED);
    }

	public ResponseEntity<Boolean> alterar(Long id, CategoriaRequestDto categoriaEntrada) {
        Optional<Categoria> buscandoCategoria = repository.findById(id);
        if (buscandoCategoria.isPresent()) {
            Categoria categoria = buscandoCategoria.get();
            categoria.setNome(categoriaEntrada.getNome());
            categoria.setDescricao(categoriaEntrada.getDescricao());
            repository.save(categoria);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

	public ResponseEntity<CategoriaResponseDto> pegarUm(Long id) {
        Optional<Categoria> buscandoCategoria = repository.findById(id);
        return buscandoCategoria.map(categoria -> new ResponseEntity<>(mapToDto(categoria), HttpStatus.OK))
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

	private CategoriaResponseDto mapToDto(Categoria categoria) {
        return new CategoriaResponseDto(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }

}