package com.projeto.certificado.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.certificado.models.Certificado;

@Repository
public interface CertificadoRepository extends JpaRepository<Certificado, Long>{
	
}