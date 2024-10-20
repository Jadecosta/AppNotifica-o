package com.distribuido.notificacao.models;

import com.distribuido.notificacao.dtos.notificacao.DtoCreateNotificacao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "notificacoes")
@Entity(name = "NotificacaoModel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class NotificacaoModel extends AuditableUserTimestampAbsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 125)
    private String titulo;
    @Column(nullable = false,length = 500)
    private String mensagem;
    @Column(nullable = false)
    private LocalDateTime data_envio;
    private Boolean enviado;
    private Boolean envio_cancelado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id", nullable = false)
    private ProfessorModel professor;

//    Criar o campo que aponta para o grupo que ira receber a notificacao


    public NotificacaoModel(DtoCreateNotificacao dados,ProfessorModel professor) {
        this.setTitulo(dados.titulo());
        this.setMensagem(dados.mensagem());
        this.setData_envio(dados.data_envio());
        this.setEnviado(false);
        this.setEnvio_cancelado(false);
        this.setProfessor(professor);
//        manter enquanto nao existe implementacao de salvar o usuario automaticamente
        this.setCreatedBy("TESTE");
    }

    public void cancelar_envio() {
        if(!this.enviado) {
            this.envio_cancelado = true;
        }
    }
}
