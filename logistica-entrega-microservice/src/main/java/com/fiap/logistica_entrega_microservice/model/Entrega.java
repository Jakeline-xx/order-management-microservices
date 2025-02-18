package com.fiap.logistica_entrega_microservice.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "entregas")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enderecoDestino;

    private String status;

    private LocalDateTime dataPrevisaoEntrega;

    private String entregador;

    private LocalDateTime dataEntregaReal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(String enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataPrevisaoEntrega() {
        return dataPrevisaoEntrega;
    }

    public void setDataPrevisaoEntrega(LocalDateTime dataPrevisaoEntrega) {
        this.dataPrevisaoEntrega = dataPrevisaoEntrega;
    }

    public String getEntregador() {
        return entregador;
    }

    public void setEntregador(String entregador) {
        this.entregador = entregador;
    }

    public LocalDateTime getDataEntregaReal() {
        return dataEntregaReal;
    }

    public void setDataEntregaReal(LocalDateTime dataEntregaReal) {
        this.dataEntregaReal = dataEntregaReal;
    }
}
