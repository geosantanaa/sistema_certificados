package com.projeto.certificado.models.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CursoRequestDto {
	
	private String nome;
	private LocalDate dataInicio;
	private LocalDate dataFinal;
	private String professor;	
	
}