package com.fiap.gestao_pedidos_microservice.usecases;

import com.fiap.gestao_pedidos_microservice.dto.ProdutoResponseDTO;
import com.fiap.gestao_pedidos_microservice.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListarProdutosUseCase {

    private final ProdutoRepository produtoRepository;

    public List<ProdutoResponseDTO> execute() {
        return produtoRepository.findAll().stream()
                .map(ProdutoResponseDTO::new)
                .collect(Collectors.toList());
    }
}
