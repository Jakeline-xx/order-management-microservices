package com.fiap.logistica_entrega_microservice.controller;

import com.fiap.logistica_entrega_microservice.usecase.AtribuirEntregadorUseCase;
import com.fiap.logistica_entrega_microservice.usecase.AtualizarStatusEntregaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entregas")
public class LogisticaController {

    private final AtribuirEntregadorUseCase atribuirEntregadorUseCase;
    private final AtualizarStatusEntregaUseCase atualizarStatusEntregaUseCase;

    @Autowired
    public LogisticaController(AtribuirEntregadorUseCase atribuirEntregadorUseCase,
                               AtualizarStatusEntregaUseCase atualizarStatusEntregaUseCase) {
        this.atribuirEntregadorUseCase = atribuirEntregadorUseCase;
        this.atualizarStatusEntregaUseCase = atualizarStatusEntregaUseCase;
    }

    @PostMapping("/{id}/atribuir-entregador")
    public ResponseEntity<Void> atribuirEntregador(@PathVariable Long id, @RequestParam String entregador) {
        atribuirEntregadorUseCase.execute(id, entregador);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/atualizar-status")
    public ResponseEntity<Void> atualizarStatus(@PathVariable Long id, @RequestParam String status) {
        atualizarStatusEntregaUseCase.execute(id, status);
        return ResponseEntity.noContent().build();
    }
}

