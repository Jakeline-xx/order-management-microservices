package com.fiap.gestao_pedidos_microservice.controller;

import com.fiap.gestao_pedidos_microservice.dto.ProdutoDTO;
import com.fiap.gestao_pedidos_microservice.dto.ProdutoResponseDTO;
import com.fiap.gestao_pedidos_microservice.usecases.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final CriarProdutoUseCase criarProdutoUseCase;
    private final ListarProdutosUseCase listarProdutosUseCase;
    private final BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase;
    private final AtualizarProdutoUseCase atualizarProdutoUseCase;
    private final ExcluirProdutoUseCase deletarProdutoUseCase;

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(criarProdutoUseCase.execute(produtoDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutos() {
        // Modificado para retornar uma lista de ProdutoResponseDTO
        List<ProdutoResponseDTO> produtos = listarProdutosUseCase.execute();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarProduto(@PathVariable Long id) {
        // Retorna ProdutoResponseDTO ao invés de ProdutoDTO
        ProdutoResponseDTO produto = buscarProdutoPorIdUseCase.execute(id);
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        // O produto atualizado agora retorna ProdutoResponseDTO
        ProdutoResponseDTO produtoAtualizado = atualizarProdutoUseCase.execute(id, produtoDTO);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        // Apenas dispara a lógica de exclusão sem retornar conteúdo
        deletarProdutoUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}

