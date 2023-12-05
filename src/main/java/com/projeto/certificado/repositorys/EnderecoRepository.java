package com.projeto.certificado.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.certificado.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
}