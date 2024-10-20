package com.distribuido.notificacao.service.impl;

import com.distribuido.notificacao.dtos.aluno.DtoCreateAluno;
import com.distribuido.notificacao.dtos.aluno.DtoDetailAluno;
import com.distribuido.notificacao.dtos.aluno.DtoListAluno;
import com.distribuido.notificacao.dtos.aluno.DtoUpdateAluno;
import com.distribuido.notificacao.models.AlunoModel;
import com.distribuido.notificacao.repository.AlunoRepository;
import com.distribuido.notificacao.service.intefaces.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlunoServiceImpl implements AlunoService {
    @Autowired
    private AlunoRepository repository;

    @Override
    public DtoDetailAluno createAluno(DtoCreateAluno dtoCreateAluno) {
        AlunoModel alunoModel = new AlunoModel(dtoCreateAluno);
        repository.save(alunoModel);
        return new DtoDetailAluno(alunoModel);
    }

    @Override
    public DtoDetailAluno updateAluno(DtoUpdateAluno dtoUpdateAluno) {
        AlunoModel alunoModel = repository.getReferenceById(dtoUpdateAluno.id());
        if(dtoUpdateAluno.nome() != null){
            alunoModel.setNome(dtoUpdateAluno.nome());
        }
        if (dtoUpdateAluno.email() != null) {
            alunoModel.setEmail(dtoUpdateAluno.email());
        }
        if(dtoUpdateAluno.senha() != null) {
            alunoModel.setSenha(dtoUpdateAluno.senha());
        }
        if (dtoUpdateAluno.matricula() != null) {
            alunoModel.setMatricula(dtoUpdateAluno.matricula());
        }
        if(dtoUpdateAluno.curso() != null) {
            alunoModel.setCurso(dtoUpdateAluno.curso());
        }
        if(dtoUpdateAluno.sala() != alunoModel.getSala()) {
            alunoModel.setSala(dtoUpdateAluno.sala());
        }
        return new DtoDetailAluno(repository.save(alunoModel));
    }

    @Override
    public DtoDetailAluno getAluno(Long id) {
        AlunoModel alunoModel = repository.getReferenceById(id);
        return new DtoDetailAluno(alunoModel);
    }

    @Override
    public Page<DtoListAluno> getAllAluno(Pageable pageable) {
        return repository.findAll(pageable).map(DtoListAluno::new);
    }

    @Override
    public void desativar(Long id) {
        AlunoModel alunoModel = repository.getReferenceById(id);
        alunoModel.inativar();
    }

    @Override
    public void ativar(Long id) {
        AlunoModel alunoModel = repository.getReferenceById(id);
        alunoModel.ativar();
    }
}
