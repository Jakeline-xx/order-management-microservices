package com.fiap.gestao_pedidos_microservice.controller;

import com.fiap.gestao_pedidos_microservice.dto.PedidoDTO;
import com.fiap.gestao_pedidos_microservice.usecase.CriarPedidoUseCase;
import com.fiap.gestao_pedidos_microservice.usecase.AtualizarStatusPedidoUseCase;
import com.fiap.gestao_pedidos_microservice.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private CriarPedidoUseCase criarPedidoUseCase;

    @Autowired
    private AtualizarStatusPedidoUseCase atualizarStatusPedidoUseCase;

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setCliente(pedidoDTO.getCliente());
        pedido.setProduto(pedidoDTO.getProduto());
        pedido.setQuantidade(pedidoDTO.getQuantidade());
        pedido.setPrecoTotal(pedidoDTO.getPrecoTotal());

        Pedido pedidoCriado = criarPedidoUseCase.execute(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarStatus(@PathVariable Long id, @RequestBody Pedido.StatusPedido status) {
        Pedido pedidoAtualizado = atualizarStatusPedidoUseCase.execute(id, status);
        return ResponseEntity.ok(pedidoAtualizado);
    }
}
