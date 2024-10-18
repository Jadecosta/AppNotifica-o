package com.distribuido.notificacao.dtos.professor;

import com.distribuido.notificacao.models.ProfessorModel;

public record DtoDetailProfessor(
        Long id,
        String nome,
        String email,
        String senha,
        String matricula,
        Boolean ativo,
        String cursoMinistrado
) {
    public DtoDetailProfessor(ProfessorModel professor) {
        this(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getSenha(),
                professor.getMatricula(),
                professor.getAtivo(),
                professor.getCursoMinistrado()
        );
    }
}
