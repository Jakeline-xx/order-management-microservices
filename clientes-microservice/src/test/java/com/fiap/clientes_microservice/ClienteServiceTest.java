package com.fiap.clientes_microservice;

import com.fiap.clientes_microservice.model.Cliente;
import com.fiap.clientes_microservice.repository.ClienteRepository;
import com.fiap.clientes_microservice.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("João");
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente clienteCriado = clienteService.criarCliente(cliente);
        assertNotNull(clienteCriado);
        assertEquals("João", clienteCriado.getNome());
    }
}
