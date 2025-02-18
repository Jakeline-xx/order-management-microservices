package com.fiap.gestao_pedidos_microservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoDTO {
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer estoque;
}
