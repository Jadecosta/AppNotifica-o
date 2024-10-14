package com.distribuido.notificacao.controller;

import com.distribuido.notificacao.domain.notificacao.*;
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
    public ResponseEntity criar(@RequestBody @Valid DadosCriarNotificacao dados, UriComponentsBuilder uriBuilder) {
        var notificacao = new Notificacao(dados);
        repository.save(notificacao);

        var uri = uriBuilder.path("/notificacao/{id}").buildAndExpand(notificacao.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoNotificacao(notificacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var notificaco = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoNotificacao(notificaco));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListarNotificacao>> listar(@PageableDefault(size = 10) Pageable pageable) {
        var page = repository.findAll(pageable).map(DadosListarNotificacao::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarNotificacao dados) {
        var notificacao = repository.getReferenceById(dados.id());
        notificacao.AtualizarDados(dados);
        return ResponseEntity.ok(new DadosDetalhamentoNotificacao(notificacao));
    }

}
