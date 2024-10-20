package com.distribuido.notificacao.models;

import com.distribuido.notificacao.dtos.adminstrador.DtoCreateAdministrador;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "AdminitradorModel")
@Table(name = "administradores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AdministradorModel  extends UsuarioAbsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public AdministradorModel(DtoCreateAdministrador dtoCreateAdministrador) {
        this.setNome(dtoCreateAdministrador.nome());
        this.setEmail(dtoCreateAdministrador.email());
        this.setSenha(dtoCreateAdministrador.senha());
        this.setMatricula(dtoCreateAdministrador.matricula());
        this.setAtivo(true);
    }
}
