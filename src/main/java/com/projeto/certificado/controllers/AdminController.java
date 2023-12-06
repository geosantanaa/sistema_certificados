package com.projeto.certificado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.certificado.models.dto.AdminRequestDto;
import com.projeto.certificado.models.dto.AdminResponseDto;
import com.projeto.certificado.services.AdminService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    public AdminService service;

    @PostMapping
    public AdminResponseDto criar(@RequestBody AdminRequestDto adminEntrada) {        
        return service.criar(adminEntrada);
    }

     @PutMapping("id/{id}")
    public boolean alterar(@PathVariable("id") Long id, @RequestBody AdminRequestDto adminEntrada) {
        return service.alterar(id, adminEntrada);
    }

    @GetMapping("id/{id}")
    public AdminResponseDto pegarUm(@PathVariable("id") Long id) {
        return service.pegarUm(id);
    }

    @DeleteMapping("id/{id}")
    public boolean excluir(@PathVariable("id") Long id) {
        return service.excluir(id);
    }

    @GetMapping
    public List<AdminResponseDto> listar() {
        return service.listar();
    }
    
    
}
