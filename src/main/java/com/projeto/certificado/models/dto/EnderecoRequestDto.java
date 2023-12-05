package com.projeto.certificado.models.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EnderecoRequestDto {
	
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;	
	
}