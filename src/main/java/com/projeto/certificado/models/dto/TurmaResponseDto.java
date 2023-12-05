package com.projeto.certificado.models.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TurmaResponseDto {
	
    private Long id;
    private String codigo;
	private String status;
	
}