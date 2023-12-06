package com.projeto.certificado.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.certificado.models.Instituicao;

@Repository
public interface InstituicaoRepository extends JpaRepository<Instituicao, Long>{
	
}