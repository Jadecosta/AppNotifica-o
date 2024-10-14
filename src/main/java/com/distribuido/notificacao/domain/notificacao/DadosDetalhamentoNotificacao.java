package com.distribuido.notificacao.domain.notificacao;

import java.time.LocalDateTime;

public record DadosDetalhamentoNotificacao(
        Long id,
        String titulo,
        String mensgem,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime data_envio,
        Boolean enviado
) {
public DadosDetalhamentoNotificacao(Notificacao notificacao) {
    this(
            notificacao.getId(),
            notificacao.getTitulo(),
            notificacao.getMensagem(),
            notificacao.getCreatedAt(),
            notificacao.getUpdatedAt(),
            notificacao.getData_envio(),
            notificacao.getEnviado()
    );
}
}
