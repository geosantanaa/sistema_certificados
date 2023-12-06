package com.projeto.certificado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.certificado.models.dto.CursoRequestDto;
import com.projeto.certificado.models.dto.CursoResponseDto;
import com.projeto.certificado.services.CursoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("curso")
public class CursoController {

    @Autowired
    public CursoService service;

    @PostMapping
    public CursoResponseDto criar(@RequestBody CursoRequestDto cursoEntrada) {        
        return service.criar(cursoEntrada);
    }

     @PutMapping("id/{id}")
    public boolean alterar(@PathVariable("id") Long id, @RequestBody CursoRequestDto cursoEntrada) {
        return service.alterar(id, cursoEntrada);
    }

    @GetMapping("id/{id}")
    public CursoResponseDto pegarUm(@PathVariable("id") Long id) {
        return service.pegarUm(id);
    }

    @DeleteMapping("id/{id}")
    public boolean excluir(@PathVariable("id") Long id) {
        return service.excluir(id);
    }

    @GetMapping
    public List<CursoResponseDto> listar() {
        return service.listar();
    }
    
    
}
