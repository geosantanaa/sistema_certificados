package com.projeto.certificado.models.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InstituicaoRequestDto {
	
    private String nome;
    private Long enderecoId;
	private String contato;	
	
}