package com.distribuido.notificacao.dtos.adminstrador;


import com.distribuido.notificacao.models.AdministradorModel;

public record DtoDetailAdministrador(
        Long id,
        String nome,
        String email,
        String senha,
        String matricula,
        Boolean ativo
) {
    public DtoDetailAdministrador(AdministradorModel administradorModel) {
        this(
                administradorModel.getId(),
                administradorModel.getNome(),
                administradorModel.getEmail(),
                administradorModel.getSenha(),
                administradorModel.getMatricula(),
                administradorModel.getAtivo()
        );
    }
}
