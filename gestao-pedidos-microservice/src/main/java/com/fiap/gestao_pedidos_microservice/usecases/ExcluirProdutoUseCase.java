package com.fiap.gestao_pedidos_microservice.usecases;

import com.fiap.gestao_pedidos_microservice.exception.ProdutoNaoEncontradoException;
import com.fiap.gestao_pedidos_microservice.model.Produto;
import com.fiap.gestao_pedidos_microservice.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExcluirProdutoUseCase {

    private final ProdutoRepository produtoRepository;

    public void execute(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado"));

        produtoRepository.delete(produto);
    }
}
