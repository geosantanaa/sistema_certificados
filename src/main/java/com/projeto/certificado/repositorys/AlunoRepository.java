package com.projeto.certificado.models.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curiculos.model.Curriculo;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
}