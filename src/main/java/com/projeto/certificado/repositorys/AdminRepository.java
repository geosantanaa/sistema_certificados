package com.projeto.certificado.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.certificado.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	
}