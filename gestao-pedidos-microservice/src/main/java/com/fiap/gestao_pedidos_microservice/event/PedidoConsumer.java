package com.fiap.gestao_pedidos_microservice.event;

import com.fiap.gestao_pedidos_microservice.model.Pedido;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PedidoConsumer {

    //@StreamListener(target = "input")
    public void ouvirPedido(@Payload Pedido pedido) {
        System.out.println("Pedido recebido: " + pedido);
    }
}
