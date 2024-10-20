package com.distribuido.notificacao.service.intefaces;

import com.distribuido.notificacao.dtos.adminstrador.DtoCreateAdministrador;
import com.distribuido.notificacao.dtos.adminstrador.DtoDetailAdministrador;
import com.distribuido.notificacao.dtos.adminstrador.DtoListAdministrador;
import com.distribuido.notificacao.dtos.adminstrador.DtoUpdateAdministrador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdministradorService {
    DtoDetailAdministrador createAdministrador(DtoCreateAdministrador dtoCreateAdministrador);
    DtoDetailAdministrador updateAdministrador(DtoUpdateAdministrador dtoUpdateAdministrador);
    DtoDetailAdministrador getAdministrador(Long id);
    Page<DtoListAdministrador> getAllAluno(Pageable pageable);
    void desativar(Long id);
    void ativar(Long id);
}
