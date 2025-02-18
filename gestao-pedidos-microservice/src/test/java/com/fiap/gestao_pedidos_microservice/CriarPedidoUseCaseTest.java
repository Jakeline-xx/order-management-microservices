package com.fiap.gestao_pedidos_microservice;

import com.fiap.gestao_pedidos_microservice.model.Pedido;
import com.fiap.gestao_pedidos_microservice.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CriarPedidoUseCaseTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private CriarPedidoUseCase criarPedidoUseCase;

    private Pedido pedido;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        pedido = new Pedido();
        pedido.setId(1L);
        pedido.setQuantidade(2);
        pedido.setPrecoTotal(100.0);
    }

    @Test
    void testCriarPedidoSucesso() {
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);

        Pedido pedidoCriado = criarPedidoUseCase.execute(pedido);

        assertNotNull(pedidoCriado);
        assertEquals(1L, pedidoCriado.getId());

        verify(pedidoRepository, times(1)).save(pedido);
    }

    @Test
    void testCriarPedidoComPedidoNulo() {
        assertThrows(IllegalArgumentException.class, () -> criarPedidoUseCase.execute(null));
    }
}
