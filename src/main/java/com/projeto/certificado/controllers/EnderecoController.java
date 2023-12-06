package com.projeto.certificado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.certificado.models.dto.EnderecoRequestDto;
import com.projeto.certificado.models.dto.EnderecoResponseDto;
import com.projeto.certificado.services.EnderecoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    public EnderecoService service;

    @PostMapping
    public EnderecoResponseDto criar(@RequestBody EnderecoRequestDto enderecoEntrada) {        
        return service.criar(enderecoEntrada);
    }

     @PutMapping("id/{id}")
    public boolean alterar(@PathVariable("id") Long id, @RequestBody EnderecoRequestDto enderecoEntrada) {
        return service.alterar(id, enderecoEntrada);
    }

    @GetMapping("id/{id}")
    public EnderecoResponseDto pegarUm(@PathVariable("id") Long id) {
        return service.pegarUm(id);
    }

    @DeleteMapping("id/{id}")
    public boolean excluir(@PathVariable("id") Long id) {
        return service.excluir(id);
    }

    @GetMapping
    public List<EnderecoResponseDto> listar() {
        return service.listar();
    }
    
    
}
