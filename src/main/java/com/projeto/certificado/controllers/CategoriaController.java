package com.projeto.certificado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.certificado.models.dto.CategoriaRequestDto;
import com.projeto.certificado.models.dto.CategoriaResponseDto;
import com.projeto.certificado.services.CategoriaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    public CategoriaService service;

    @PostMapping
    public CategoriaResponseDto criar(@RequestBody CategoriaRequestDto categoriaEntrada) {        
        return service.criar(categoriaEntrada);
    }

     @PutMapping("id/{id}")
    public boolean alterar(@PathVariable("id") Long id, @RequestBody CategoriaRequestDto categoriaEntrada) {
        return service.alterar(id, categoriaEntrada);
    }

    @GetMapping("id/{id}")
    public CategoriaResponseDto pegarUm(@PathVariable("id") Long id) {
        return service.pegarUm(id);
    }

    @DeleteMapping("id/{id}")
    public boolean excluir(@PathVariable("id") Long id) {
        return service.excluir(id);
    }

    @GetMapping
    public List<CategoriaResponseDto> listar() {
        return service.listar();
    }
    
    
}
