package com.projeto.certificado.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "curso")
public class Curso {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String nome;

    @Column(name = "data_cadastro")
	private LocalDate dataInicio;

    @Column(name = "data_cadastro")
	private LocalDate dataFinal;

	@Column(nullable = true, unique = true, length = 14)
	private String professor;

	public Curso(String nome, LocalDate dataInicio, LocalDate dataFinal, String professor) {
    }


}