package com.distribuido.notificacao.controller;

import com.distribuido.notificacao.dtos.notificacao.DtoCreateNotificacao;
import com.distribuido.notificacao.dtos.notificacao.DtoDetailNotificacao;
import com.distribuido.notificacao.dtos.notificacao.DtoListNotificacao;
import com.distribuido.notificacao.dtos.notificacao.DtoUpdateNotificacao;
import com.distribuido.notificacao.models.NotificacaoModel;
import com.distribuido.notificacao.repository.NotificacaoRepository;
import com.distribuido.notificacao.service.intefaces.NotificacaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/notificacao")
public class NotificacaoController {
    @Autowired
    private NotificacaoService service;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid DtoCreateNotificacao dados) {
        DtoDetailNotificacao notificacao = service.createNotificacao(dados);
//        Corrigir esse ResponseEntity retornando-o para o detail
        return ResponseEntity.ok(notificacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        DtoDetailNotificacao notificacao = service.getNotificaco(id);
        return ResponseEntity.ok(notificacao);
    }

    @GetMapping
    public ResponseEntity<Page<DtoListNotificacao>> list(@PageableDefault(size = 10) Pageable pageable) {
        Page page = service.getAllNotificacao(pageable);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DtoUpdateNotificacao dados) {
        DtoDetailNotificacao notificacao = service.updateNotificacao(dados);
        return ResponseEntity.ok(notificacao);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity cancelar_envio(@PathVariable Long id) {
        service.deleteNotificacao(id);
        return ResponseEntity.noContent().build();
    }

}
