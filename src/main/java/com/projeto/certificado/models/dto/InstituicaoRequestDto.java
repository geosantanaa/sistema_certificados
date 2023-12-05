package com.projeto.certificado.models.dto;

import com.projeto.certificado.models.Endereco;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InstituicaoRequestDto {
	
    private String nome;
    private Endereco endereco;
	private String contato;	
	
}