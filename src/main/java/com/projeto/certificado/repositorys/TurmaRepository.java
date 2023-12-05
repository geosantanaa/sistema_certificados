package com.projeto.certificado.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.certificado.models.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
	
}