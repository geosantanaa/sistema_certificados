package com.projeto.certificado.models.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CursoResponseDto {
	
	private Long id;
	private String nome;
	private LocalDate dataInicio;
	private LocalDate dataFinal;
	private String professor;	
	
}