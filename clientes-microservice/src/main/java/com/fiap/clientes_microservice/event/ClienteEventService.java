package com.fiap.clientes_microservice.event;

import com.fiap.clientes_microservice.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class ClienteEventService {

    @Autowired
    private StreamBridge streamBridge;

    public void enviarEventoClienteCriado(Cliente cliente) {
        streamBridge.send("clienteCriado-out-0", cliente);
    }
}
