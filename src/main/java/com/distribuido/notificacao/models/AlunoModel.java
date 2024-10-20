package com.distribuido.notificacao.models;

import com.distribuido.notificacao.dtos.aluno.DtoCreateAluno;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "AlunoModel")
@Table(name = "alunos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AlunoModel extends UsuarioAbsModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String curso;
    @Column(nullable = false)
    private int sala;

    public AlunoModel(DtoCreateAluno dtoCreateAluno) {
        this.setNome(dtoCreateAluno.nome());
        this.setEmail(dtoCreateAluno.email());
        this.setSenha(dtoCreateAluno.senha());
        this.setMatricula(dtoCreateAluno.matricula());
        this.setAtivo(true);
        this.setCurso(dtoCreateAluno.curso());
        this.setSala(dtoCreateAluno.sala());
    }
}
