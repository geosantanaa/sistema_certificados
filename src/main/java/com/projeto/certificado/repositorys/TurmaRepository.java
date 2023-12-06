package com.projeto.certificado.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.certificado.models.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{
	
}