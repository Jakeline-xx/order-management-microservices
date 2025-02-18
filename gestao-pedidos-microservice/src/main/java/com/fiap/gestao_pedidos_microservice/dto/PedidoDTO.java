package com.fiap.gestao_pedidos_microservice.dto;

import lombok.Data;

@Data
public class PedidoDTO {

    private String cliente;
    private String produto;
    private Integer quantidade;
    private Double precoTotal;
}
