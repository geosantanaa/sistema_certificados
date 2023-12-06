package com.projeto.certificado.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "aluno")
public class Aluno {


    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false, length = 100)
	private String email;

    @ManyToOne
    @JoinColumn(name = "turmaId")
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "cursoId")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "certificadoId")
    private Certificado certificado;



}