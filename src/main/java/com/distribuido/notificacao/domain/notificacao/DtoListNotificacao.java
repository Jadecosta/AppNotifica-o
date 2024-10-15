package com.distribuido.notificacao.domain.notificacao;

import java.time.LocalDateTime;

public record DtoListNotificacao(
        Long id,
        String titulo,
        LocalDateTime data_envio,
        Boolean enviado
) {
    public DtoListNotificacao(Notificacao notificacao){
        this(
                notificacao.getId(),
                notificacao.getTitulo(),
                notificacao.getData_envio(),
                notificacao.getEnviado()
        );
    }
}
