package com.projeto.certificado.models.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curiculos.model.Curriculo;

public interface AdminRepository extends JpaRepository<Admin, Long>{
	
}