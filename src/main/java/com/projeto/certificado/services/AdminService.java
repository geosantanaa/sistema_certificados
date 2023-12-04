package com.example.curiculos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.curiculos.model.Curriculo;
import com.example.curiculos.model.dto.CurriculoEntradaDto;
import com.example.curiculos.model.dto.CurriculoSaidaDto;
import com.example.curiculos.repository.CurriculoRepository;
import com.projeto.certificado.models.Admin;
import com.projeto.certificado.models.dto.AdminRequestDto;
import com.projeto.certificado.models.dto.AdminResponseDto;
import com.projeto.certificado.repositorys.AdminRepository;

@org.springframework.stereotype.Service
public class AdminService {

	@Autowired
	private AdminRepository repository;


	public ResponseEntity<AdminResponseDto> criar(AdminRequestDto adminEntrada) {
        Admin admin = new Admin(adminEntrada.getNome(), adminEntrada.getEmail());
        repository.save(admin);
        return new ResponseEntity<>(mapToDto(admin), HttpStatus.CREATED);
    }

	public ResponseEntity<Boolean> alterar(Long id, AdminRequestDto adminEntrada) {
        Optional<Admin> buscandoAdmin = repository.findById(id);
        if (buscandoAdmin.isPresent()) {
            Admin admin = buscandoAdmin.get();
            admin.setNome(adminEntrada.getNome());
            admin.setEmail(adminEntrada.getEmail());
            repository.save(admin);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

	public ResponseEntity<AdminResponseDto> pegarUm(Long id) {
        Optional<Admin> buscandoAdmin = repository.findById(id);
        return buscandoAdmin.map(admin -> new ResponseEntity<>(mapToDto(admin), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

	public ResponseEntity<Boolean> excluir(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

	public ResponseEntity<List<AdminResponseDto>> listar() {
        List<Admin> listaAdmins = repository.findAll();
        List<AdminResponseDto> listaSaida = listaAdmins.stream().map(this::mapToDto).collect(Collectors.toList());
        return new ResponseEntity<>(listaSaida, HttpStatus.OK);
    }

	private AdminResponseDto mapToDto(Admin admin) {
        return new AdminResponseDto(admin.getId(), admin.getNome(), admin.getEmail());
    }

}