package com.fiap.logistica_entrega_microservice.repository;


import com.fiap.logistica_entrega_microservice.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
