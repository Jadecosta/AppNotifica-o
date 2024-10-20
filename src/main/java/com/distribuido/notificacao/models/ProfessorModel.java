package com.distribuido.notificacao.models;

import com.distribuido.notificacao.dtos.professor.DtoCreateProfessor;
import com.distribuido.notificacao.dtos.professor.DtoUpdateProfessor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity(name = "ProfessorModel")
@Table(name = "professores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorModel extends UsuarioAbsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "professor",cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<NotificacaoModel> notificacoes;
//  Tornar essa coluna em uma tabela
    @Column(name = "curso_ministrado", length = 100)
    private String cursoMinistrado;

    public ProfessorModel(DtoCreateProfessor dtoCreateProfessor) {
        this.setNome(dtoCreateProfessor.nome());
        this.setEmail(dtoCreateProfessor.email());
        this.setSenha(dtoCreateProfessor.senha());
        this.setMatricula(dtoCreateProfessor.matricula());
        this.setAtivo(true);
        this.setCursoMinistrado(dtoCreateProfessor.cursoMinistrado());
    }

    public void updateDados(DtoUpdateProfessor dtoUpdateProfessor) {
        if(dtoUpdateProfessor.nome() != null) {
            this.setNome(dtoUpdateProfessor.nome());
        }
        if (dtoUpdateProfessor.email() != null) {
            this.setEmail(dtoUpdateProfessor.email());
        }
        if (dtoUpdateProfessor.senha() != null) {
            this.setSenha(dtoUpdateProfessor.senha());
        }
        if (dtoUpdateProfessor.matricula() != null) {
            this.setMatricula(dtoUpdateProfessor.matricula());
        }
        if (dtoUpdateProfessor.cursoMinstrado() != null) {
            this.setCursoMinistrado(dtoUpdateProfessor.cursoMinstrado());
        }
    }

}
