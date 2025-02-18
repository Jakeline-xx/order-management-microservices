package com.fiap.logistica_entrega_microservice;

import com.fiap.logistica_entrega_microservice.model.Entrega;
import com.fiap.logistica_entrega_microservice.repository.EntregaRepository;
import com.fiap.logistica_entrega_microservice.usecase.AtribuirEntregadorUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AtribuirEntregadorUseCaseTest {

    @Mock
    private EntregaRepository entregaRepository;

    @InjectMocks
    private AtribuirEntregadorUseCase atribuirEntregadorUseCase;

    private Entrega entrega;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        entrega = new Entrega();
        entrega.setId(1L);
        entrega.setEnderecoDestino("Rua 123");
        entrega.setStatus("Aguardando");
    }

    @Test
    void testAtribuirEntregadorSucesso() {
        when(entregaRepository.findById(1L)).thenReturn(java.util.Optional.of(entrega));
        when(entregaRepository.save(any(Entrega.class))).thenReturn(entrega);

        entrega = atribuirEntregadorUseCase.execute(1L, "Entregador 1");

        assertEquals("Entregador 1", entrega.getEntregador());
        assertEquals("Em andamento", entrega.getStatus());
    }
}
