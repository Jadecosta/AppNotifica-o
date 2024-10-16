package com.distribuido.notificacao.controller;

import com.distribuido.notificacao.dtos.notificacao.DtoCreateNotificacao;
import com.distribuido.notificacao.dtos.notificacao.DtoDetailNotificacao;
import com.distribuido.notificacao.dtos.notificacao.DtoListNotificacao;
import com.distribuido.notificacao.dtos.notificacao.DtoUpdateNotificacao;
import com.distribuido.notificacao.models.NotificacaoModel;
import com.distribuido.notificacao.repository.NotificacaoRepository;
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
    private NotificacaoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid DtoCreateNotificacao dados, UriComponentsBuilder uriBuilder) {
        var notificacao = new NotificacaoModel(dados);
        repository.save(notificacao);

        var uri = uriBuilder.path("/notificacao/{id}").buildAndExpand(notificacao.getId()).toUri();
        return ResponseEntity.created(uri).body(new DtoDetailNotificacao(notificacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var notificaco = repository.getReferenceById(id);
        return ResponseEntity.ok(new DtoDetailNotificacao(notificaco));
    }

    @GetMapping
    public ResponseEntity<Page<DtoListNotificacao>> list(@PageableDefault(size = 10) Pageable pageable) {
        var page = repository.findAll(pageable).map(DtoListNotificacao::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DtoUpdateNotificacao dados) {
        var notificacao = repository.getReferenceById(dados.id());
        notificacao.updateDados(dados);
        return ResponseEntity.ok(new DtoDetailNotificacao(notificacao));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity cancelar_envio(@PathVariable Long id) {
        var notificacao = repository.getReferenceById(id);
        notificacao.cancelar_envio();
        return ResponseEntity.noContent().build();
    }

}
