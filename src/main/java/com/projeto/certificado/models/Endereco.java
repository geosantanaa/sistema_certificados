package com.projeto.certificado.models;

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
@Entity(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String logradouro;

	@Column(nullable = true, unique = true, length = 14)
	private String numero;

	@Column(nullable = false, length = 100)
	private String bairro;

	@Column(nullable = false, length = 100)
	private String cidade;

	
	public Endereco(String logradouro, String numero, String bairro, String cidade) {
	}

}