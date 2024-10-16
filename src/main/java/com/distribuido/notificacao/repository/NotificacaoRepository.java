package com.distribuido.notificacao.repository;

import com.distribuido.notificacao.models.NotificacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface NotificacaoRepository extends JpaRepository<NotificacaoModel,Long> {
}