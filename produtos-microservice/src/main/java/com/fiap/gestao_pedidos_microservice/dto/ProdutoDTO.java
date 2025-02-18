package com.fiap.gestao_pedidos_microservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoDTO {
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer estoque;
}
