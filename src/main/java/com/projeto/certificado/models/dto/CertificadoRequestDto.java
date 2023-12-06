package com.projeto.certificado.models.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CertificadoRequestDto {
	
	private String titulo;
	private String descricao;
	private LocalDate dataEmissao;
    private Long categoriaId;
    private Long instituicaoId;
		
	
}