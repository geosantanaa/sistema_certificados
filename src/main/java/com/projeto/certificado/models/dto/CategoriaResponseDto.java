package com.projeto.certificado.models.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoriaResponseDto {
	
    private Long id;
	private String nome;
	private String descricao;	
	
}