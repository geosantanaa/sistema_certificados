package com.projeto.certificado.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.certificado.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
}