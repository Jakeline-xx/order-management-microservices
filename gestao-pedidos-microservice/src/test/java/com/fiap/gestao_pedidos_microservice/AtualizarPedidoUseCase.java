package com.fiap.gestao_pedidos_microservice;

import com.fiap.gestao_pedidos_microservice.repository.PedidoRepository;
import com.fiap.gestao_pedidos_microservice.model.Pedido;
import org.springframework.stereotype.Service;

@Service
public class AtualizarPedidoUseCase {

    private final PedidoRepository pedidoRepository;

    public AtualizarPedidoUseCase(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido execute(Long id, Pedido pedidoAtualizado) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
        pedido.setQuantidade(pedidoAtualizado.getQuantidade());
        return pedidoRepository.save(pedido);
    }
}
