package com.distribuido.notificacao.repository;

import com.distribuido.notificacao.models.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoModel,Long> {
}
