package com.distribuido.notificacao.service.impl;

import com.distribuido.notificacao.dtos.professor.DtoCreateProfessor;
import com.distribuido.notificacao.dtos.professor.DtoDetailProfessor;
import com.distribuido.notificacao.dtos.professor.DtoListProfessor;
import com.distribuido.notificacao.dtos.professor.DtoUpdateProfessor;
import com.distribuido.notificacao.models.ProfessorModel;
import com.distribuido.notificacao.repository.ProfessorRepository;
import com.distribuido.notificacao.service.intefaces.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    private ProfessorRepository repository;


    @Override
    public DtoDetailProfessor createProfessor(DtoCreateProfessor dtoCreateProfessor) {
        ProfessorModel professorModel = new ProfessorModel(dtoCreateProfessor);
        repository.save(professorModel);
        return new DtoDetailProfessor(professorModel);
    }

    @Override
    public DtoDetailProfessor updateProfessor(DtoUpdateProfessor dtoUpdateProfessor) {
        ProfessorModel professorModel = repository.getReferenceById(dtoUpdateProfessor.id());
        professorModel.updateDados(dtoUpdateProfessor);
        return new DtoDetailProfessor(professorModel);
    }

    @Override
    public DtoDetailProfessor getProfessor(Long id) {
        ProfessorModel professorModel = repository.getReferenceById(id);
        return new DtoDetailProfessor(professorModel);
    }

    @Override
    public Page<DtoListProfessor> getAllProfessor(Pageable pageable) {
        return repository.findAll(pageable).map(DtoListProfessor::new);
    }

    @Override
    public void desativar(Long id) {
        ProfessorModel professorModel = repository.getReferenceById(id);
        professorModel.inativar();
    }

    @Override
    public void ativar(Long id) {
        ProfessorModel professorModel = repository.getReferenceById(id);
        professorModel.ativar();
    }
}
