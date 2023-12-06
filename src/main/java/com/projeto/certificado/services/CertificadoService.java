package com.projeto.certificado.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.certificado.models.Categoria;
import com.projeto.certificado.models.Certificado;
import com.projeto.certificado.models.Instituicao;
import com.projeto.certificado.models.dto.CertificadoRequestDto;
import com.projeto.certificado.models.dto.CertificadoResponseDto;
import com.projeto.certificado.repositorys.CategoriaRepository;
import com.projeto.certificado.repositorys.CertificadoRepository;
import com.projeto.certificado.repositorys.InstituicaoRepository;

@Service
public class CertificadoService {

	@Autowired
	private CertificadoRepository repository;

    @Autowired
	private CategoriaRepository categoriaRepository;

    @Autowired
	private InstituicaoRepository instituicaoRepository;

    @Autowired
	private ModelMapper mapper;


    public CertificadoResponseDto criar(CertificadoRequestDto certificadoEntrada) {
        Certificado certificado = mapper.map(certificadoEntrada, Certificado.class);
        Optional<Categoria> buscandoCategoria = categoriaRepository.findById(certificadoEntrada.getCategoriaId());
        if (buscandoCategoria.isPresent()) {
            Categoria categoria = buscandoCategoria.get();
            certificado.setCategoria(categoria);

        }
    
        Optional<Instituicao> buscandoInstituicao = instituicaoRepository.findById(certificadoEntrada.getInstituicaoId());
        if (buscandoInstituicao.isPresent()) {
            Instituicao instituicao = buscandoInstituicao.get();
            certificado.setInstituicao(instituicao);
        }
    
        Certificado saida = repository.save(certificado);
        return mapper.map(saida, CertificadoResponseDto.class);
    }
    
    

	public boolean alterar(Long id, CertificadoRequestDto certificadoEntrada) {
        if (id == null || id <= 0) {
            return false;
        }
    
        Optional<Certificado> buscandoCertificado = repository.findById(id);
    
        if (buscandoCertificado.isPresent()) {
            Certificado certificado = buscandoCertificado.get();
            
            try {
                mapper.map(certificadoEntrada, certificado);
                repository.save(certificado);
                return true;
            } catch (Exception ex) {
                return false;
            }
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