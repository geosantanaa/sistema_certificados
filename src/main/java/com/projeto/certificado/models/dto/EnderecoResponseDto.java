package com.projeto.certificado.models.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EnderecoResponseDto {

    private Long id;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	
	
    public EnderecoResponseDto(Long id, String logradouro, String numero, String bairro, String cidade) {
    }
	
}