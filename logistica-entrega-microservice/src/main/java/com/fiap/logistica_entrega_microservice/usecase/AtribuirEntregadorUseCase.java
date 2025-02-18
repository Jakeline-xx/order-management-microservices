package com.fiap.logistica_entrega_microservice.usecase;

import com.fiap.logistica_entrega_microservice.model.Entrega;
import com.fiap.logistica_entrega_microservice.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtribuirEntregadorUseCase {

    private final EntregaRepository entregaRepository;

    @Autowired
    public AtribuirEntregadorUseCase(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    public Entrega execute(Long entregaId, String entregador) {
        Entrega entrega = entregaRepository.findById(entregaId)
                .orElseThrow(() -> new IllegalArgumentException("Entrega não encontrada"));
        entrega.setEntregador(entregador);
        entrega.setStatus("Em andamento"); // Mudando o status após atribuição
        return entregaRepository.save(entrega);
    }
}
