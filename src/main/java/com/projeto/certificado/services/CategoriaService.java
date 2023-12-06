package com.projeto.certificado.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.certificado.models.Categoria;
import com.projeto.certificado.models.dto.CategoriaRequestDto;
import com.projeto.certificado.models.dto.CategoriaResponseDto;
import com.projeto.certificado.repositorys.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

    @Autowired
	private ModelMapper mapper;


	public CategoriaResponseDto criar(CategoriaRequestDto categoriaEntrada) {
        Categoria categoria = mapper.map(categoriaEntrada, Categoria.class);
        repository.save(categoria);

        CategoriaResponseDto saida = mapper.map(categoria, CategoriaResponseDto.class);
        return saida;
    }

    public boolean alterar(Long id, CategoriaRequestDto categoriaEntrada) {
        if (id == null || id <= 0) {
            return false;
        }
    
        Optional<Categoria> buscandoCategoria = repository.findById(id);
    
        if (buscandoCategoria.isPresent()) {
            Categoria categoria = buscandoCategoria.get();
            
            try {
                mapper.map(categoriaEntrada, categoria);
                repository.save(categoria);
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
    
        return false;
    }
    

	public CategoriaResponseDto pegarUm(Long id) {
        Optional<Categoria> buscandoCategoria = repository.findById(id);

        if(buscandoCategoria.isPresent()){
            Categoria categoria = buscandoCategoria.get();
            CategoriaResponseDto saida = mapper.map(categoria, CategoriaResponseDto.class);
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

	public List<CategoriaResponseDto> listar() {
        List<Categoria> listaCategorias = repository.findAll();
        return listaCategorias.stream().map(categoria -> mapper.map(categoria, CategoriaResponseDto.class)).collect(Collectors.toList());
    }

}