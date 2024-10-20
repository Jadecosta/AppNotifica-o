package com.distribuido.notificacao.dtos.aluno;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DtoCreateAluno(
        @NotBlank(message = "O campo nome não pode ser vazio")
        @Size(max = 255)
        String nome,
        @NotBlank(message = "O campo email pode ser vazio")
        @Email
        @Size(max = 125)
        String email,
        @NotBlank(message = "O campo senha pode ser vazio")
        @Size(max = 255)
        String senha,
        @NotBlank(message = "O campo matricula não pode ser vazio")
        @Size(max = 6)
        String matricula,
        @NotBlank(message = "O campo curso não pode ser vazio")
        String curso,
        @NotNull(message = "O campo sala não pode ser vazio")
        int sala
) {
}
