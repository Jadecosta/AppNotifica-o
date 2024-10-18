package com.distribuido.notificacao.dtos.professor;

import com.distribuido.notificacao.models.ProfessorModel;

public record DtoListProfessor(
        Long id,
        String nome,
        String email,
        String matricula,
        Boolean ativo
) {
    public DtoListProfessor(ProfessorModel professor) {
        this(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getMatricula(),
                professor.getAtivo()
        );
    }
}
