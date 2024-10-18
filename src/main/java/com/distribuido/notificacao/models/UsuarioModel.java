package com.distribuido.notificacao.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@MappedSuperclass
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 255)
    private String nome;
    @Column(nullable = false,length = 125)
    private String email;
    @Column(nullable = false,length = 255)
    private String senha;
    @Column(nullable = false,length = 6,unique = true)
    private String matricula;
    private Boolean ativo;

    public void ativar() {
        if(!this.getAtivo()) {
            this.setAtivo(true);
        }
    }
    public void inativar() {
        if(!this.getAtivo()) {
            this.setAtivo(false);
        }
    }
}
