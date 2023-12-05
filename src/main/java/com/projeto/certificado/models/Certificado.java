package com.projeto.certificado.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "certificado")
public class Certificado {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String titulo;

	@Column(nullable = true, unique = true, length = 500)
	private String descricao;

    @Column(name = "data_cadastro")
	private LocalDate dataEmissao;

    @ManyToOne
    @JoinColumn(name = "categoriaId")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "instituicaoId")
    private Instituicao instituicao;
	
	public Certificado(String titulo, String descricao, LocalDate dataEmissao, Long categoria) {
    }

    public Certificado(String titulo2, String descricao2, LocalDate dataEmissao2, Categoria categoria2) {
    }

}