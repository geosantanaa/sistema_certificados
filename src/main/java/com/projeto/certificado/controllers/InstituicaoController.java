package com.projeto.certificado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.certificado.models.dto.InstituicaoRequestDto;
import com.projeto.certificado.models.dto.InstituicaoResponseDto;
import com.projeto.certificado.services.InstituicaoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("instituicao")
public class InstituicaoController {

    @Autowired
    public InstituicaoService service;

    @PostMapping
    public InstituicaoResponseDto criar(@RequestBody InstituicaoRequestDto instituicaoEntrada) {        
        return service.criar(instituicaoEntrada);
    }

     @PutMapping("id/{id}")
    public boolean alterar(@PathVariable("id") Long id, @RequestBody InstituicaoRequestDto instituicaoEntrada) {
        return service.alterar(id, instituicaoEntrada);
    }

    @GetMapping("id/{id}")
    public InstituicaoResponseDto pegarUm(@PathVariable("id") Long id) {
        return service.pegarUm(id);
    }

    @DeleteMapping("id/{id}")
    public boolean excluir(@PathVariable("id") Long id) {
        return service.excluir(id);
    }

    @GetMapping
    public List<InstituicaoResponseDto> listar() {
        return service.listar();
    }
    
    
}
