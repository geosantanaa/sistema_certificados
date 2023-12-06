package com.projeto.certificado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.certificado.models.dto.TurmaRequestDto;
import com.projeto.certificado.models.dto.TurmaResponseDto;
import com.projeto.certificado.services.TurmaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("turma")
public class TurmaController {

    @Autowired
    public TurmaService service;

    @PostMapping
    public TurmaResponseDto criar(@RequestBody TurmaRequestDto turmaEntrada) {        
        return service.criar(turmaEntrada);
    }

     @PutMapping("id/{id}")
    public boolean alterar(@PathVariable("id") Long id, @RequestBody TurmaRequestDto turmaEntrada) {
        return service.alterar(id, turmaEntrada);
    }

    @GetMapping("id/{id}")
    public TurmaResponseDto pegarUm(@PathVariable("id") Long id) {
        return service.pegarUm(id);
    }

    @DeleteMapping("id/{id}")
    public boolean excluir(@PathVariable("id") Long id) {
        return service.excluir(id);
    }

    @GetMapping
    public List<TurmaResponseDto> listar() {
        return service.listar();
    }
    
    
}
