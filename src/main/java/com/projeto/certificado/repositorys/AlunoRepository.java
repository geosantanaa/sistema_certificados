package com.projeto.certificado.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.certificado.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
}