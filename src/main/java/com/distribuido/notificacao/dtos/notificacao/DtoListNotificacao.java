package com.distribuido.notificacao.dtos.notificacao;

import com.distribuido.notificacao.models.NotificacaoModel;

import java.time.LocalDateTime;

public record DtoListNotificacao(
        Long id,
        String titulo,
        LocalDateTime data_envio,
        Boolean enviado
) {
    public DtoListNotificacao(NotificacaoModel notificacao){
        this(
                notificacao.getId(),
                notificacao.getTitulo(),
                notificacao.getData_envio(),
                notificacao.getEnviado()
        );
    }
}
