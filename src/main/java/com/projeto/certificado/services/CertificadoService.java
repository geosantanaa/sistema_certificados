package com.projeto.certificado.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.projeto.certificado.models.Aluno;
import com.projeto.certificado.models.Certificado;
import com.projeto.certificado.models.dto.CertificadoRequestDto;
import com.projeto.certificado.models.dto.CertificadoResponseDto;
import com.projeto.certificado.repositorys.AlunoRepository;
import com.projeto.certificado.repositorys.CertificadoRepository;

@org.springframework.stereotype.Service
public class CertificadoService {

	@Autowired
	private CertificadoRepository repository;

    @Autowired
	private AlunoRepository alunoRepository;

	public ResponseEntity<CertificadoResponseDto> criar(CertificadoRequestDto certificadoEntrada) {
        Certificado certificado = new Certificado(certificadoEntrada.getTitulo(), certificadoEntrada.getDescricao(), certificadoEntrada.getDataEmissao(), certificadoEntrada.getCategoria());
        repository.save(certificado);
        return new ResponseEntity<>(mapToDto(certificado), HttpStatus.CREATED);
    }

    public ResponseEntity<Boolean> alterarCertificado(Long id, CertificadoRequestDto certificadoEntrada) {
        Optional<Certificado> buscandoCertificado = repository.findById(id);
    
        if (buscandoCertificado.isPresent()) {
            Certificado certificado = buscandoCertificado.get();
    
            Long alunoId = certificadoEntrada.getAlunoId();
    
            Optional<Aluno> alunoOptional = alunoRepository.findById(alunoId);
    
            if (alunoOptional.isPresent()) {
                Aluno aluno = alunoOptional.get();
    
                certificado.setTitulo(certificadoEntrada.getTitulo());
                certificado.setDescricao(certificadoEntrada.getDescricao());
                certificado.setDataEmissao(certificadoEntrada.getDataEmissao());
                certificado.setCategoria(certificadoEntrada.getCategoria());
    
                aluno.setCertificado(certificado);
    
                repository.save(certificado);
                alunoRepository.save(aluno);
    
                return new ResponseEntity<>(true, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
            }
        }
    
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
    
        

	public ResponseEntity<CertificadoResponseDto> pegarUm(Long id) {
        Optional<Certificado> buscandoCertificado = repository.findById(id);
        return buscandoCertificado.map(certificado -> new ResponseEntity<>(mapToDto(certificado), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

	public ResponseEntity<Boolean> excluir(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

	public ResponseEntity<List<CertificadoResponseDto>> listar() {
        List<Certificado> listaCertificados = repository.findAll();
        List<CertificadoResponseDto> listaSaida = listaCertificados.stream().map(this::mapToDto).collect(Collectors.toList());
        return new ResponseEntity<>(listaSaida, HttpStatus.OK);
    }

	private CertificadoResponseDto mapToDto(Certificado certificado) {
        return new CertificadoResponseDto(certificado.getId(), certificado.getTitulo(), certificado.getDescricao(), certificado.getDataEmissao(), certificado.getCategoria());
    }

}