package com.distribuido.notificacao.repository;

import com.distribuido.notificacao.models.AdministradorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<AdministradorModel,Long> {
}
