package com.distribuido.notificacao.service.intefaces;


import com.distribuido.notificacao.dtos.professor.DtoCreateProfessor;
import com.distribuido.notificacao.dtos.professor.DtoDetailProfessor;
import com.distribuido.notificacao.dtos.professor.DtoListProfessor;
import com.distribuido.notificacao.dtos.professor.DtoUpdateProfessor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProfessorService {
    DtoDetailProfessor createProfessor(DtoCreateProfessor dtoCreateProfessor);
    DtoDetailProfessor updateProfessor(DtoUpdateProfessor dtoUpdateProfessor);
    DtoDetailProfessor getProfessor(Long id);
    Page<DtoListProfessor> getAllProfessor(Pageable pageable);
    void desativar(Long id);
    void ativar(Long id);
}
