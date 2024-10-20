package com.distribuido.notificacao.dtos.aluno;

import com.distribuido.notificacao.models.AlunoModel;

public record DtoListAluno(
        Long id,
        String nome,
        String email,
        String matricula,
        Boolean ativo,
        String curso,
        int Sala
) {
    public DtoListAluno(AlunoModel aluno) {
        this(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getMatricula(),
                aluno.getAtivo(),
                aluno.getCurso(),
                aluno.getSala()
        );
    }
}
