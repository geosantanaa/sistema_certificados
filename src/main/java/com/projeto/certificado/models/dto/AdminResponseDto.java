package com.projeto.certificado.models.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminResponseDto {

    private Long id;
	private String nome;
	private String email;

	 public AdminResponseDto(Long id, String nome, String email) {
		id = this.id;
		nome = this.nome;
		email = this.email;
    }
	
}