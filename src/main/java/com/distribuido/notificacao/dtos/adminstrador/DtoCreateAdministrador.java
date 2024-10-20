package com.distribuido.notificacao.dtos.adminstrador;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DtoCreateAdministrador(
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
        String matricula
) {
}
