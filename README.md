# Sistema de Gestão de Pedidos e Catálogo de Produtos

Este projeto é um sistema de **gestão de pedidos e catálogo de produtos** composto por quatro microsserviços independentes: **Gestão de Pedidos**, **Catálogo de Produtos**, **Logística de Entrega** e **Gestão de Clientes**. Cada microsserviço é responsável por um conjunto específico de funcionalidades dentro de um sistema maior, que permite realizar a gestão de pedidos, catalogação de produtos, controle de estoque e logística de entrega.

## Arquitetura

O sistema é baseado em **arquitetura de microsserviços**, o que significa que cada parte do sistema é independente, escalável e pode ser atualizada ou mantida separadamente sem afetar outros microsserviços.

A arquitetura do sistema é composta por:

1. **Microsserviço de Gestão de Pedidos**: Responsável pelo recebimento, processamento e controle dos pedidos.
2. **Microsserviço de Catálogo de Produtos**: Gerencia a listagem, detalhes e controle de estoque dos produtos.
3. **Microsserviço de Logística de Entrega**: Responsável pelo planejamento de rotas, estimativas de entrega e atualização de status.
4. **Microsserviço de Gestão de Clientes**: Mantém os dados dos clientes, como nome, e-mail e histórico de pedidos.

### Tecnologias Utilizadas

- **Spring Boot**: Framework principal para construção dos microsserviços.
- **Spring Data JPA**: Para a persistência de dados em um banco de dados relacional.
- **Spring Cloud Stream**: Para comunicação assíncrona entre os microsserviços através de eventos.
- **MySQL**: Banco de dados utilizado para persistir os dados de cada microsserviço.

## Design dos Serviços

### 1. **Gestão de Pedidos**
Responsável pelo recebimento e processamento dos pedidos. Esse serviço interage com o serviço de logística para realizar o rastreamento da entrega.

- **Endpoints**:
    - `POST /pedidos`: Criar um novo pedido.
    - `GET /pedidos/{id}`: Buscar informações de um pedido.
    - `PUT /pedidos/{id}`: Atualizar o status de um pedido.
    - `DELETE /pedidos/{id}`: Cancelar um pedido.

### 2. **Catálogo de Produtos**
Responsável pela listagem de produtos, controle de estoque e preços. Ele também permite importar dados de produtos em massa (ex: de arquivos CSV).

- **Endpoints**:
    - `GET /produtos`: Listar todos os produtos.
    - `GET /produtos/{id}`: Buscar um produto pelo ID.
    - `POST /produtos`: Criar um novo produto.
    - `PUT /produtos/{id}`: Atualizar um produto.
    - `DELETE /produtos/{id}`: Excluir um produto.

### 3. **Logística de Entrega**
Este microsserviço cuida do planejamento de rotas, atribuição de entregadores e rastreamento de entregas.

- **Endpoints**:
    - `POST /entregas`: Criar uma entrega.
    - `GET /entregas/{id}`: Buscar uma entrega pelo ID.
    - `PUT /entregas/{id}`: Atualizar o status da entrega.
    - `DELETE /entregas/{id}`: Cancelar uma entrega.

### 4. **Gestão de Clientes**
Este serviço mantém o cadastro de clientes, bem como informações de contato e histórico de pedidos.

- **Endpoints**:
    - `POST /clientes`: Criar um novo cliente.
    - `GET /clientes/{id}`: Buscar um cliente pelo ID.
    - `PUT /clientes/{id}`: Atualizar os dados de um cliente.
    - `DELETE /clientes/{id}`: Excluir um cliente.

## Implantação

### Pré-requisitos

Para rodar este projeto, é necessário ter o **Java 17** e o **Maven** instalados.

- **Java 17**: [Instalar Java 17](https://adoptopenjdk.net/)
- **Maven**: [Instalar Maven](https://maven.apache.org/install.html)

### Passos para Rodar a Aplicação

1. Clone o repositório:

   ```bash
   git clone 

