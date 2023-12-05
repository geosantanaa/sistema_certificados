package com.projeto.certificado.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "aluno")
@AllArgsConstructor
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

      public Aluno(String nome, String email, Long turmaId, Long cursoId, Long certificadoId) {
    }

}