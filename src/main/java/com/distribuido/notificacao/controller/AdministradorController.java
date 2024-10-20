package com.distribuido.notificacao.controller;

import com.distribuido.notificacao.dtos.adminstrador.DtoCreateAdministrador;
import com.distribuido.notificacao.dtos.adminstrador.DtoDetailAdministrador;
import com.distribuido.notificacao.dtos.adminstrador.DtoListAdministrador;
import com.distribuido.notificacao.dtos.adminstrador.DtoUpdateAdministrador;
import com.distribuido.notificacao.dtos.aluno.DtoCreateAluno;
import com.distribuido.notificacao.service.impl.AdministradorServiceImpl;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {
    @Autowired
    private AdministradorServiceImpl service;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid DtoCreateAdministrador dtoCreateAdministrador) {
        DtoDetailAdministrador administrador = service.createAdministrador(dtoCreateAdministrador);
        return ResponseEntity.ok(administrador);
    }
    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        DtoDetailAdministrador administrador = service.getAdministrador(id);
        return ResponseEntity.ok(administrador);
    }
    @GetMapping
    public ResponseEntity<Page<DtoListAdministrador>> list(@PageableDefault(size = 10) Pageable pageable) {
        Page page = service.getAllAluno(pageable);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DtoUpdateAdministrador dtoUpdateAdministrador) {
        DtoDetailAdministrador administrador = service.updateAdministrador(dtoUpdateAdministrador);
        return ResponseEntity.ok(administrador);
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
