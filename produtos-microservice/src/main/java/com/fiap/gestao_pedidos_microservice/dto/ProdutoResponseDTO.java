package com.fiap.gestao_pedidos_microservice.dto;

import com.fiap.gestao_pedidos_microservice.model.Produto;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProdutoResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer estoque;

    public ProdutoResponseDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.estoque = produto.getEstoque();
    }
}
