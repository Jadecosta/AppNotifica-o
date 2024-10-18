package com.distribuido.notificacao.controller;

import com.distribuido.notificacao.dtos.professor.DtoCreateProfessor;
import com.distribuido.notificacao.dtos.professor.DtoDetailProfessor;
import com.distribuido.notificacao.dtos.professor.DtoListProfessor;
import com.distribuido.notificacao.dtos.professor.DtoUpdateProfessor;
import com.distribuido.notificacao.service.intefaces.ProfessorService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    private ProfessorService service;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid DtoCreateProfessor dtoCreateProfessor) {
        DtoDetailProfessor professor = service.createProfessor(dtoCreateProfessor);
        return ResponseEntity.ok(professor);
    }
    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        DtoDetailProfessor professor = service.getProfessor(id);
        return ResponseEntity.ok(professor);
    }
    @GetMapping
    public ResponseEntity<Page<DtoListProfessor>> list(@PageableDefault(size = 10) Pageable pageable) {
        Page page = service.getAllProfessor(pageable);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DtoUpdateProfessor dtoUpdateProfessor) {
        DtoDetailProfessor professor = service.updateProfessor(dtoUpdateProfessor);
        return ResponseEntity.ok(professor);
    }
    @PutMapping("/ativar/{id}")
    @Transactional ResponseEntity ativar(@PathVariable Long id) {
        service.ativar(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    @Transactional ResponseEntity inativar(@PathVariable Long id) {
        service.desativar(id);
        return ResponseEntity.noContent().build();
    }

}
