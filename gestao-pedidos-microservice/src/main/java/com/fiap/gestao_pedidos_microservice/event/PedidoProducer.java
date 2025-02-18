package com.fiap.gestao_pedidos_microservice.event;

import com.fiap.gestao_pedidos_microservice.model.Pedido;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class PedidoProducer {

    private final StreamBridge streamBridge;

    public PedidoProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void enviarPedidoCriado(Pedido pedido) {
        streamBridge.send("output", pedido);
    }
}
