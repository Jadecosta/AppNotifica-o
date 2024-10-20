package com.distribuido.notificacao.dtos.professor;

import jakarta.validation.constraints.NotNull;

public record DtoUpdateProfessor(
        @NotNull
        Long id,
        String nome,
        String email,
        String senha,
        String matricula,
        String cursoMinstrado,
        String tipoUsuario
) {
}
