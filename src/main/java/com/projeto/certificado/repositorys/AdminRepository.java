package com.projeto.certificado.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.certificado.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
	
}