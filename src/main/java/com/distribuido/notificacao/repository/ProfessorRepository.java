package com.distribuido.notificacao.repository;

import com.distribuido.notificacao.models.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<ProfessorModel,Long> {
}
