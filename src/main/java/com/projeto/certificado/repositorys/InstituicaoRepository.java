package com.projeto.certificado.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.certificado.models.Instituicao;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long>{
	
}