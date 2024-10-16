package com.distribuido.notificacao.dtos.notificacao;

import com.distribuido.notificacao.models.NotificacaoModel;

import java.time.LocalDateTime;

public record DtoDetailNotificacao(
        Long id,
        String titulo,
        String mensgem,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime data_envio,
        Boolean enviado,
        Boolean envio_cancelado
) {
public DtoDetailNotificacao(NotificacaoModel notificacao) {
    this(
            notificacao.getId(),
            notificacao.getTitulo(),
            notificacao.getMensagem(),
            notificacao.getCreatedAt(),
            notificacao.getUpdatedAt(),
            notificacao.getData_envio(),
            notificacao.getEnviado(),
            notificacao.getEnvio_cancelado()
    );
}
}
