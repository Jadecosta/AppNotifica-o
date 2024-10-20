package com.distribuido.notificacao.service.impl;


import com.distribuido.notificacao.dtos.notificacao.DtoCreateNotificacao;
import com.distribuido.notificacao.dtos.notificacao.DtoDetailNotificacao;
import com.distribuido.notificacao.dtos.notificacao.DtoListNotificacao;
import com.distribuido.notificacao.dtos.notificacao.DtoUpdateNotificacao;
import com.distribuido.notificacao.models.NotificacaoModel;
import com.distribuido.notificacao.models.ProfessorModel;
import com.distribuido.notificacao.repository.NotificacaoRepository;
import com.distribuido.notificacao.repository.ProfessorRepository;
import com.distribuido.notificacao.service.intefaces.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoServiceImpl implements NotificacaoService {
    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public DtoDetailNotificacao createNotificacao(DtoCreateNotificacao dtoCreateNotificacaoicacao) {
        ProfessorModel professor = professorRepository.getReferenceById(dtoCreateNotificacaoicacao.professorId());
        NotificacaoModel notificacaoModel = new NotificacaoModel(dtoCreateNotificacaoicacao,professor);
        notificacaoRepository.save(notificacaoModel);
        return new DtoDetailNotificacao(notificacaoModel);
    }

    @Override
    public DtoDetailNotificacao updateNotificacao(DtoUpdateNotificacao dtoUpdateNotificacaoficacao) {
        NotificacaoModel notificacaoModel = notificacaoRepository.getReferenceById(dtoUpdateNotificacaoficacao.id());
        if(!notificacaoModel.getEnviado()){
            if(dtoUpdateNotificacaoficacao.titulo() != null){
                notificacaoModel.setTitulo(dtoUpdateNotificacaoficacao.titulo());
            }
            if(dtoUpdateNotificacaoficacao.mensagem() != null) {
                notificacaoModel.setMensagem(dtoUpdateNotificacaoficacao.mensagem());
            }
            if (dtoUpdateNotificacaoficacao.data_envio() != null) {
                notificacaoModel.setData_envio(dtoUpdateNotificacaoficacao.data_envio());
            }
            if(dtoUpdateNotificacaoficacao.professorId() != null) {
                ProfessorModel professorModel = professorRepository.getReferenceById(dtoUpdateNotificacaoficacao.professorId());
                notificacaoModel.setProfessor(professorModel);
            }
        }
        return new DtoDetailNotificacao(notificacaoRepository.save(notificacaoModel));
    }

    @Override
    public DtoDetailNotificacao getNotificaco(Long id) {
        NotificacaoModel notificacaoModel = notificacaoRepository.getReferenceById(id);
        return new DtoDetailNotificacao(notificacaoModel);
    }

    @Override
    public void deleteNotificacao(Long id) {
        NotificacaoModel notificacaoModel = notificacaoRepository.getReferenceById(id);
        notificacaoModel.cancelar_envio();
    }

    @Override
    public Page<DtoListNotificacao> getAllNotificacao(Pageable pageable) {
        return notificacaoRepository.findAll(pageable).map(DtoListNotificacao::new);
    }
}
