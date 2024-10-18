package com.distribuido.notificacao.service.impl;


import com.distribuido.notificacao.dtos.notificacao.DtoCreateNotificacao;
import com.distribuido.notificacao.dtos.notificacao.DtoDetailNotificacao;
import com.distribuido.notificacao.dtos.notificacao.DtoListNotificacao;
import com.distribuido.notificacao.dtos.notificacao.DtoUpdateNotificacao;
import com.distribuido.notificacao.models.NotificacaoModel;
import com.distribuido.notificacao.repository.NotificacaoRepository;
import com.distribuido.notificacao.service.intefaces.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoServiceImpl implements NotificacaoService {
    @Autowired
    private NotificacaoRepository repository;

    @Override
    public DtoDetailNotificacao createNotificacao(DtoCreateNotificacao dtoCreateNotificacaoicacao) {
        NotificacaoModel notificacaoModel = new NotificacaoModel(dtoCreateNotificacaoicacao);
        repository.save(notificacaoModel);
        return new DtoDetailNotificacao(notificacaoModel);
    }

    @Override
    public DtoDetailNotificacao updateNotificacao(DtoUpdateNotificacao dtoUpdateNotificacaoficacao) {
        NotificacaoModel notificacaoModel = repository.getReferenceById(dtoUpdateNotificacaoficacao.id());
        notificacaoModel.updateDados(dtoUpdateNotificacaoficacao);
        return new DtoDetailNotificacao(notificacaoModel);
    }

    @Override
    public DtoDetailNotificacao getNotificaco(Long id) {
        NotificacaoModel notificacaoModel = repository.getReferenceById(id);
        return new DtoDetailNotificacao(notificacaoModel);
    }

    @Override
    public void deleteNotificacao(Long id) {
        NotificacaoModel notificacaoModel = repository.getReferenceById(id);
        notificacaoModel.cancelar_envio();
    }

    @Override
    public Page<DtoListNotificacao> getAllNotificacao(Pageable pageable) {
        return repository.findAll(pageable).map(DtoListNotificacao::new);
    }
}
