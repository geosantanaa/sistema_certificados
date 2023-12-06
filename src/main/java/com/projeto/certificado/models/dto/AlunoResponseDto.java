package com.projeto.certificado.models.dto;

import com.projeto.certificado.models.Certificado;
import com.projeto.certificado.models.Curso;
import com.projeto.certificado.models.Turma;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AlunoResponseDto {

    private Long id;
	private String nome;
	private String email;
    private Turma turma;
    private Curso curso;
    private Certificado certificado;
	
}