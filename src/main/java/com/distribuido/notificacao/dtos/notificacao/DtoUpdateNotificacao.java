package com.distribuido.notificacao.dtos.notificacao;

import com.distribuido.notificacao.models.ProfessorModel;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DtoUpdateNotificacao(
        @NotNull
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime data_envio,
        Long professorId
) {
}
