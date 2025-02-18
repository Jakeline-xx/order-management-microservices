package com.fiap.gestao_pedidos_microservice.usecase;

import com.fiap.gestao_pedidos_microservice.model.Pedido;
import com.fiap.gestao_pedidos_microservice.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CriarPedidoUseCase {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido execute(Pedido pedido) {
        pedido.setStatus(Pedido.StatusPedido.CRIADO);  // Definir o status inicial
        pedido.setDataCriacao(LocalDateTime.now());
        return pedidoRepository.save(pedido);
    }
}
