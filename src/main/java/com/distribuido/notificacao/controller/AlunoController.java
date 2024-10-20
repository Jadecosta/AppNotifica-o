package com.distribuido.notificacao.controller;

import com.distribuido.notificacao.dtos.aluno.DtoCreateAluno;
import com.distribuido.notificacao.dtos.aluno.DtoDetailAluno;
import com.distribuido.notificacao.dtos.aluno.DtoListAluno;
import com.distribuido.notificacao.dtos.aluno.DtoUpdateAluno;
import com.distribuido.notificacao.service.impl.AlunoServiceImpl;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoServiceImpl service;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid DtoCreateAluno dtoCreateAluno) {
        DtoDetailAluno aluno = service.createAluno(dtoCreateAluno);
        return ResponseEntity.ok(aluno);
    }
    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        DtoDetailAluno aluno = service.getAluno(id);
        return ResponseEntity.ok(aluno);
    }
    @GetMapping
    public ResponseEntity<Page<DtoListAluno>> list(@PageableDefault(size = 10) Pageable pageable){
        Page page = service.getAllAluno(pageable);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DtoUpdateAluno dtoUpdateAluno) {
        DtoDetailAluno aluno = service.updateAluno(dtoUpdateAluno);
        return ResponseEntity.ok(aluno);
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
