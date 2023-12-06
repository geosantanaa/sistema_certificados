package com.projeto.certificado.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.certificado.models.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
}