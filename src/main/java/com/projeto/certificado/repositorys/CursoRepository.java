package com.projeto.certificado.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.certificado.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{
	
}