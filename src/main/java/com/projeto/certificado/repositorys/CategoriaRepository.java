package com.projeto.certificado.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.certificado.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}