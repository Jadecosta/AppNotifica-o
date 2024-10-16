package com.distribuido.notificacao.models;

import com.distribuido.notificacao.dtos.notificacao.DtoCreateNotificacao;
import com.distribuido.notificacao.dtos.notificacao.DtoUpdateNotificacao;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Table(name = "notificacoes")
@Entity(name = "NotificacaoModel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class NotificacaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String mensagem;
    @Column(nullable = false)
    private LocalDateTime data_envio;
    private Boolean enviado;
    private Boolean envio_cancelado;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

//    criar o campo que registra o usuario mandou a mensagem
//    Criar o campo que aponta para o grupo que ira receber a notificacao


    public NotificacaoModel(DtoCreateNotificacao dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data_envio = dados.data_envio();
        this.enviado = false;
        this.envio_cancelado = false;
    }

    public void updateDados(@Valid DtoUpdateNotificacao dados) {
        if(!this.enviado) {
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

    public void cancelar_envio() {
        this.envio_cancelado = true;
    }
}
