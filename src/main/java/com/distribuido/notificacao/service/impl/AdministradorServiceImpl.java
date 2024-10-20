package com.distribuido.notificacao.service.impl;

import com.distribuido.notificacao.dtos.adminstrador.DtoCreateAdministrador;
import com.distribuido.notificacao.dtos.adminstrador.DtoDetailAdministrador;
import com.distribuido.notificacao.dtos.adminstrador.DtoListAdministrador;
import com.distribuido.notificacao.dtos.adminstrador.DtoUpdateAdministrador;
import com.distribuido.notificacao.models.AdministradorModel;
import com.distribuido.notificacao.repository.AdministradorRepository;
import com.distribuido.notificacao.service.intefaces.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServiceImpl implements AdministradorService {
    @Autowired
    private AdministradorRepository repository;


    @Override
    public DtoDetailAdministrador createAdministrador(DtoCreateAdministrador dtoCreateAdministrador) {
        AdministradorModel administradorModel = new AdministradorModel(dtoCreateAdministrador);
        repository.save(administradorModel);
        return new DtoDetailAdministrador(administradorModel);
    }

    @Override
    public DtoDetailAdministrador updateAdministrador(DtoUpdateAdministrador dtoUpdateAdministrador) {
        AdministradorModel administradorModel = repository.getReferenceById(dtoUpdateAdministrador.id());
        if (dtoUpdateAdministrador.nome() != null) {
            administradorModel.setNome(dtoUpdateAdministrador.nome());
        }
        if (dtoUpdateAdministrador.email() != null) {
            administradorModel.setEmail(dtoUpdateAdministrador.email());
        }
        if (dtoUpdateAdministrador.senha() != null) {
            administradorModel.setSenha(dtoUpdateAdministrador.senha());
        }
        if (dtoUpdateAdministrador.matricula() != null) {
            administradorModel.setMatricula(dtoUpdateAdministrador.matricula());
        }
        return new DtoDetailAdministrador(repository.save(administradorModel));
    }

    @Override
    public DtoDetailAdministrador getAdministrador(Long id) {
        AdministradorModel administradorModel = repository.getReferenceById(id);
        return new DtoDetailAdministrador(administradorModel);
    }

    @Override
    public Page<DtoListAdministrador> getAllAluno(Pageable pageable) {
        return repository.findAll(pageable).map(DtoListAdministrador::new);
    }

    @Override
    public void desativar(Long id) {
        AdministradorModel administradorModel = repository.getReferenceById(id);
        System.out.println(administradorModel.getAtivo());
        administradorModel.inativar();
    }

    @Override
    public void ativar(Long id) {
        AdministradorModel administradorModel = repository.getReferenceById(id);
        administradorModel.ativar();
    }
}
