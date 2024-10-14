package com.distribuido.notificacao.domain.notificacao;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Table(name = "notificacoes")
@Entity(name = "Notificacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime data_envio;
    private Boolean enviado;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

//    criar o campo que registra o usuario mandou a mensagem
//    Criar o campo que aponta para o grupo que irá receber a notificaçahno

    public Notificacao(DadosCriarNotificacao dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data_envio = dados.data_envio();
        this.enviado = false;
    }

    public void AtualizarDados(@Valid DadosAtualizarNotificacao dados) {
        if(!enviado) {
            if(dados.titulo() != null) {
                this.titulo = dados.titulo();
            }
            if(dados.mensagem() != null) {
                this.mensagem = dados.mensagem();
            }
            if(dados.data_envio() != null) {
                this.data_envio = dados.data_envio();
            }
        }
    }
}
