package com.distribuido.notificacao.dtos.adminstrador;

import jakarta.validation.constraints.NotNull;

public record DtoUpdateAdministrador(
        @NotNull
        Long id,
        String nome,
        String email,
        String senha,
        String matricula
) {
}
