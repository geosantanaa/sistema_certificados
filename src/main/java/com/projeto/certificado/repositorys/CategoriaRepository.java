package com.projeto.certificado.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.certificado.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}