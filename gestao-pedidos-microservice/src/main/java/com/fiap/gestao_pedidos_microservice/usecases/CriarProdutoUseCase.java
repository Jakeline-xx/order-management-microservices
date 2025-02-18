package com.fiap.gestao_pedidos_microservice.usecases;

import com.fiap.gestao_pedidos_microservice.dto.ProdutoDTO;
import com.fiap.gestao_pedidos_microservice.dto.ProdutoResponseDTO;
import com.fiap.gestao_pedidos_microservice.model.Produto;
import com.fiap.gestao_pedidos_microservice.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriarProdutoUseCase {

    private final ProdutoRepository produtoRepository;

    public ProdutoResponseDTO execute(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setEstoque(dto.getEstoque());

        produtoRepository.save(produto);
        return new ProdutoResponseDTO(produto);
    }
}
