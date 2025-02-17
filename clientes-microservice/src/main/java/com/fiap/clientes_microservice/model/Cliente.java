package com.fiap.clientes_microservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max = 100, message = "Nome não pode ter mais de 100 caracteres")
    private String nome;

    @NotBlank(message = "Email não pode ser vazio")
    @Size(max = 100, message = "Email não pode ter mais de 100 caracteres")
    private String email;

    @NotBlank(message = "Telefone não pode ser vazio")
    private String telefone;

    @Column(name = "endereco")
    private String endereco;

}
