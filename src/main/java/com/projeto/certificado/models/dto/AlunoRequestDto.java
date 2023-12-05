package com.projeto.certificado.models.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AlunoRequestDto {
	
	private String nome;
	private String email;
    private Long turmaId;
    private Long cursoId;
    private Long certificadoId;
	
}