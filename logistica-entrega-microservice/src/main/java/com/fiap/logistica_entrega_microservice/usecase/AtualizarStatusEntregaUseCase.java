package com.fiap.logistica_entrega_microservice.usecase;

import com.fiap.logistica_entrega_microservice.model.Entrega;
import com.fiap.logistica_entrega_microservice.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AtualizarStatusEntregaUseCase {

    private final EntregaRepository entregaRepository;

    @Autowired
    public AtualizarStatusEntregaUseCase(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    public Entrega execute(Long entregaId, String novoStatus) {
        Entrega entrega = entregaRepository.findById(entregaId)
                .orElseThrow(() -> new IllegalArgumentException("Entrega não encontrada"));
        entrega.setStatus(novoStatus);
        if ("Concluída".equals(novoStatus)) {
            entrega.setDataEntregaReal(LocalDateTime.now()); // Marca a data de entrega real
        }
        return entregaRepository.save(entrega);
    }
}
