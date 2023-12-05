package com.projeto.certificado.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.certificado.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
	
}