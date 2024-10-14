package com.distribuido.notificacao.domain.notificacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAtualizarNotificacao(
        @NotNull
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime data_envio
) {
}
