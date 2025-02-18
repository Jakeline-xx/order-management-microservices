package com.fiap.gestao_pedidos_microservice.usecase;


import com.fiap.gestao_pedidos_microservice.model.Pedido;
import com.fiap.gestao_pedidos_microservice.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarStatusPedidoUseCase {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido execute(Long id, Pedido.StatusPedido status) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setStatus(status);
        return pedidoRepository.save(pedido);
    }
}
