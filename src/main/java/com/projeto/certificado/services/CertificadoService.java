package com.projeto.certificado.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.certificado.models.Certificado;
import com.projeto.certificado.models.dto.CertificadoRequestDto;
import com.projeto.certificado.models.dto.CertificadoResponseDto;
import com.projeto.certificado.repositorys.CertificadoRepository;

@Service
public class CertificadoService {

	@Autowired
	private CertificadoRepository repository;

    @Autowired
	private ModelMapper mapper;


	public CertificadoResponseDto criar(CertificadoRequestDto certificadoEntrada) {
        Certificado certificado = mapper.map(certificadoEntrada, Certificado.class);
        repository.save(certificado);

        CertificadoResponseDto saida = mapper.map(certificado, CertificadoResponseDto.class);
        return saida;
    }

	public boolean alterar(Long id, CertificadoRequestDto certificadoEntrada) {
        Optional<Certificado> buscandoCertificado = repository.findById(id);

        if(buscandoCertificado.isPresent()){
            Certificado certificado = buscandoCertificado.get();
            mapper.map(certificadoEntrada, Certificado.class);
            repository.save(certificado);
            return true;
        }
        return false;
    }

	public CertificadoResponseDto pegarUm(Long id) {
        Optional<Certificado> buscandoCertificado = repository.findById(id);

        if(buscandoCertificado.isPresent()){
            Certificado certificado = buscandoCertificado.get();
            CertificadoResponseDto saida = mapper.map(certificado, CertificadoResponseDto.class);
            return saida;
        }
        return null;
    }

	public boolean excluir(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

	public List<CertificadoResponseDto> listar() {
        List<Certificado> listaCertificados = repository.findAll();
        return listaCertificados.stream().map(certificado -> mapper.map(certificado, CertificadoResponseDto.class)).collect(Collectors.toList());
    }

}