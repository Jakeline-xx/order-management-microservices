package com.fiap.gestao_pedidos_microservice.usecases;

import com.fiap.gestao_pedidos_microservice.dto.ProdutoDTO;
import com.fiap.gestao_pedidos_microservice.dto.ProdutoResponseDTO;
import com.fiap.gestao_pedidos_microservice.exception.ProdutoNaoEncontradoException;
import com.fiap.gestao_pedidos_microservice.model.Produto;
import com.fiap.gestao_pedidos_microservice.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtualizarProdutoUseCase {

    private final ProdutoRepository produtoRepository;

    public ProdutoResponseDTO execute(Long id, ProdutoDTO dto) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado"));

        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setEstoque(dto.getEstoque());

        produtoRepository.save(produto);
        return new ProdutoResponseDTO(produto);
    }
}
