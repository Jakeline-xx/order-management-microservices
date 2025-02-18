package com.fiap.gestao_pedidos_microservice;

import org.springframework.stereotype.Service;
import com.fiap.gestao_pedidos_microservice.model.Pedido;
import com.fiap.gestao_pedidos_microservice.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CriarPedidoUseCase {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public CriarPedidoUseCase(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido execute(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo");
        }
        return pedidoRepository.save(pedido);
    }
}
