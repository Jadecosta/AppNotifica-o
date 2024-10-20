package com.distribuido.notificacao.dtos.notificacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DtoCreateNotificacao(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        LocalDateTime data_envio,
        @NotNull
        Long professorId
) {
}