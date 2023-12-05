package com.projeto.certificado.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.certificado.models.Certificado;

public interface CertificadoRepository extends JpaRepository<Certificado, Long>{
	
}