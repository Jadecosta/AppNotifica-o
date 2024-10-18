package com.distribuido.notificacao.service.intefaces;

import com.distribuido.notificacao.dtos.notificacao.DtoCreateNotificacao;
import com.distribuido.notificacao.dtos.notificacao.DtoDetailNotificacao;
import com.distribuido.notificacao.dtos.notificacao.DtoListNotificacao;
import com.distribuido.notificacao.dtos.notificacao.DtoUpdateNotificacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotificacaoService {
    DtoDetailNotificacao createNotificacao(DtoCreateNotificacao dtoCreateNotificacaonotificacao);
    DtoDetailNotificacao updateNotificacao(DtoUpdateNotificacao dtoUpdateNotificacao);
    DtoDetailNotificacao getNotificaco(Long id);
    Page<DtoListNotificacao> getAllNotificacao(Pageable pageable);
    void deleteNotificacao(Long id);
}
