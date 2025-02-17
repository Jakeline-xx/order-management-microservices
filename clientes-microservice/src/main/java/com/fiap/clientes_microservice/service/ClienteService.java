package com.fiap.clientes_microservice.service;

import com.fiap.clientes_microservice.model.Cliente;
import com.fiap.clientes_microservice.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setEmail(clienteAtualizado.getEmail());
        cliente.setTelefone(clienteAtualizado.getTelefone());
        cliente.setEndereco(clienteAtualizado.getEndereco());
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
