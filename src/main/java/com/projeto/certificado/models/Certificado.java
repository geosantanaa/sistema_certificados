package com.projeto.certificado.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Entity(name = "certificado")
public class Certificado {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = true, unique = true, length = 500)
    private String descricao;

    @Column(name = "data_emissao")
    private LocalDate dataEmissao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoriaId")
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instituicaoId")
    private Instituicao instituicao;
	

}