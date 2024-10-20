package com.distribuido.notificacao.dtos.aluno;

import com.distribuido.notificacao.models.AlunoModel;

public record DtoDetailAluno(
        Long id,
        String nome,
        String email,
        String senha,
        String matricula,
        Boolean ativo,
        String curso,
        int Sala
) {
    public DtoDetailAluno(AlunoModel aluno) {
        this(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getSenha(),
                aluno.getMatricula(),
                aluno.getAtivo(),
                aluno.getCurso(),
                aluno.getSala()
        );
    }
}
