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

    public AlunoResponseDto(Long id, String nome, String email, Turma turma, Curso curso, Certificado certificado) {
        id = this.id;
        nome = this.nome;
        email = this.email;
        turma = this.turma;
        curso = this.curso;
        certificado = this.certificado;

    }
	
}