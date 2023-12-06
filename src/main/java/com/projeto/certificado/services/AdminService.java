package com.projeto.certificado.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.certificado.models.Admin;
import com.projeto.certificado.models.dto.AdminRequestDto;
import com.projeto.certificado.models.dto.AdminResponseDto;
import com.projeto.certificado.repositorys.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;

    @Autowired
    public ModelMapper mapper;


	public AdminResponseDto criar(AdminRequestDto adminEntrada) {
        Admin admin = mapper.map(adminEntrada, Admin.class);
        repository.save(admin);

        AdminResponseDto saida = mapper.map(admin, AdminResponseDto.class);
        return saida;
    }

	public boolean alterar(Long id, AdminRequestDto adminEntrada) {
        Optional<Admin> buscandoAdmin = repository.findById(id);

        if(buscandoAdmin.isPresent()){
            Admin admin = buscandoAdmin.get();
            mapper.map(adminEntrada, Admin.class);
            repository.save(admin);
            return true;
        }
        return false;
    }

	public AdminResponseDto pegarUm(Long id) {
        Optional<Admin> buscandoAdmin = repository.findById(id);

        if(buscandoAdmin.isPresent()){
            Admin admin = buscandoAdmin.get();
            AdminResponseDto saida = mapper.map(admin, AdminResponseDto.class);
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

	public List<AdminResponseDto> listar() {
        List<Admin> listaAdmins = repository.findAll();
        return listaAdmins.stream().map(admin -> mapper.map(admin, AdminResponseDto.class)).collect(Collectors.toList());
    }


}