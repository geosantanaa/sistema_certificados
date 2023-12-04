package com.projeto.model.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.certificado.models.Certificado;
import com.projeto.certificado.models.Curso;

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