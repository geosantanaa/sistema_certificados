package com.projeto.certificado.models.dto;

import java.time.LocalDate;

import com.projeto.certificado.models.Categoria;
import com.projeto.certificado.models.Instituicao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CertificadoResponseDto {
	
    private Long id;
	private String titulo;
	private String descricao;
	private LocalDate dataEmissao;
    private Categoria categoria;
    private Instituicao instituicao;
    
      public CertificadoResponseDto(Long id, String titulo, String descricao, LocalDate dataEmissao, Categoria categoria2) {
    }
	
}