package com.projeto.certificado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.certificado.models.dto.CertificadoRequestDto;
import com.projeto.certificado.models.dto.CertificadoResponseDto;
import com.projeto.certificado.services.CertificadoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("certificado")
public class CertificadoController {

    @Autowired
    public CertificadoService service;

    @PostMapping
    public CertificadoResponseDto criar(@RequestBody CertificadoRequestDto certificadoEntrada) {        
        return service.criar(certificadoEntrada);
    }

     @PutMapping("id/{id}")
    public boolean alterar(@PathVariable("id") Long id, @RequestBody CertificadoRequestDto certificadoEntrada) {
        return service.alterar(id, certificadoEntrada);
    }

    @GetMapping("id/{id}")
    public CertificadoResponseDto pegarUm(@PathVariable("id") Long id) {
        return service.pegarUm(id);
    }

    @DeleteMapping("id/{id}")
    public boolean excluir(@PathVariable("id") Long id) {
        return service.excluir(id);
    }

    @GetMapping
    public List<CertificadoResponseDto> listar() {
        return service.listar();
    }
    
    
}
