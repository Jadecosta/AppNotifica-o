package com.distribuido.notificacao.dtos.aluno;

import jakarta.validation.constraints.NotNull;

public record DtoUpdateAluno(
        @NotNull
        Long id,
        String nome,
        String email,
        String senha,
        String matricula,
        String curso,
        int sala
) {
}
