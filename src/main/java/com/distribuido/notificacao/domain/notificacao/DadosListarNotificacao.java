package com.distribuido.notificacao.domain.notificacao;

import org.aspectj.weaver.ast.Not;

import java.time.LocalDateTime;

public record DadosListarNotificacao(
        Long id,
        String titulo,
        LocalDateTime data_envio,
        Boolean enviado
) {
    public DadosListarNotificacao(Notificacao notificacao){
        this(
                notificacao.getId(),
                notificacao.getTitulo(),
                notificacao.getData_envio(),
                notificacao.getEnviado()
        );
    }
}
