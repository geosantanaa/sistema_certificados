package com.projeto.certificado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.certificado.models.dto.AlunoRequestDto;
import com.projeto.certificado.models.dto.AlunoResponseDto;
import com.projeto.certificado.services.AlunoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    public AlunoService service;

    @PostMapping
    public AlunoResponseDto criar(@RequestBody AlunoRequestDto alunoEntrada) {        
        return service.criar(alunoEntrada);
    }

     @PutMapping("id/{id}")
    public boolean alterar(@PathVariable("id") Long id, @RequestBody AlunoRequestDto alunoEntrada) {
        return service.alterar(id, alunoEntrada);
    }

    @GetMapping("id/{id}")
    public AlunoResponseDto pegarUm(@PathVariable("id") Long id) {
        return service.pegarUm(id);
    }

    @DeleteMapping("id/{id}")
    public boolean excluir(@PathVariable("id") Long id) {
        return service.excluir(id);
    }

    @GetMapping
    public List<AlunoResponseDto> listar() {
        return service.listar();
    }
    
    
}
