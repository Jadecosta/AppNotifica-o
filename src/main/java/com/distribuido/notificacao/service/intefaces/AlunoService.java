package com.distribuido.notificacao.service.intefaces;


import com.distribuido.notificacao.dtos.aluno.DtoCreateAluno;
import com.distribuido.notificacao.dtos.aluno.DtoDetailAluno;
import com.distribuido.notificacao.dtos.aluno.DtoListAluno;
import com.distribuido.notificacao.dtos.aluno.DtoUpdateAluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlunoService {
    DtoDetailAluno createAluno(DtoCreateAluno dtoCreateProfessor);
    DtoDetailAluno updateAluno(DtoUpdateAluno dtoUpdateProfessor);
    DtoDetailAluno getAluno(Long id);
    Page<DtoListAluno> getAllAluno(Pageable pageable);
    void desativar(Long id);
    void ativar(Long id);
}
