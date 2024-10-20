package com.distribuido.notificacao.dtos.adminstrador;

import com.distribuido.notificacao.models.AdministradorModel;

public record DtoListAdministrador(
        Long id,
        String nome,
        String email,
        String matricula,
        Boolean ativo
) {
    public DtoListAdministrador(AdministradorModel administradorModel) {
        this(
                administradorModel.getId(),
                administradorModel.getNome(),
                administradorModel.getEmail(),
                administradorModel.getMatricula(),
                administradorModel.getAtivo()
        );
    }
}
