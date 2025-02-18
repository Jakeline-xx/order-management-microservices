package com.fiap.gestao_pedidos_microservice;


import com.fiap.gestao_pedidos_microservice.controller.ProdutoController;
import com.fiap.gestao_pedidos_microservice.dto.ProdutoDTO;
import com.fiap.gestao_pedidos_microservice.dto.ProdutoResponseDTO;
import com.fiap.gestao_pedidos_microservice.usecases.AtualizarProdutoUseCase;
import com.fiap.gestao_pedidos_microservice.usecases.BuscarProdutoPorIdUseCase;
import com.fiap.gestao_pedidos_microservice.usecases.ExcluirProdutoUseCase;
import com.fiap.gestao_pedidos_microservice.usecases.ListarProdutosUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProdutoControllerTest {

    @InjectMocks
    private ProdutoController produtoController;

    @Mock
    private ListarProdutosUseCase listarProdutosUseCase;

    @Mock
    private BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase;

    @Mock
    private AtualizarProdutoUseCase atualizarProdutoUseCase;

    @Mock
    private ExcluirProdutoUseCase deletarProdutoUseCase;

    private ProdutoDTO produtoDTO;
    private ProdutoResponseDTO produtoResponseDTO;

    @BeforeEach
    public void setUp() {
        produtoDTO = new ProdutoDTO();
        produtoDTO.setNome("Produto Teste");
        produtoDTO.setDescricao("Descrição do Produto");

    }

    @Test
    public void testListarProdutos() {
        when(listarProdutosUseCase.execute()).thenReturn(List.of(produtoResponseDTO));

        ResponseEntity<List<ProdutoResponseDTO>> response = produtoController.listarProdutos();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        verify(listarProdutosUseCase, times(1)).execute();
    }

    @Test
    public void testBuscarProduto() {
        Long id = 1L;
        when(buscarProdutoPorIdUseCase.execute(id)).thenReturn(produtoResponseDTO);

        ResponseEntity<ProdutoResponseDTO> response = produtoController.buscarProduto(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(id, response.getBody().getId());
        verify(buscarProdutoPorIdUseCase, times(1)).execute(id);
    }

    @Test
    public void testAtualizarProduto() {
        Long id = 1L;
        when(atualizarProdutoUseCase.execute(id, produtoDTO)).thenReturn(produtoResponseDTO);

        ResponseEntity<ProdutoResponseDTO> response = produtoController.atualizarProduto(id, produtoDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(id, response.getBody().getId());
        verify(atualizarProdutoUseCase, times(1)).execute(id, produtoDTO);
    }

    @Test
    public void testDeletarProduto() {
        Long id = 1L;
        doNothing().when(deletarProdutoUseCase).execute(id);

        ResponseEntity<Void> response = produtoController.deletarProduto(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(deletarProdutoUseCase, times(1)).execute(id);
    }
}
