# Vehicle Sale Application

## Descrição
O Vehicle Sale Application é uma aplicação para gerenciamento de vendas de veículos. Ela permite cadastrar veículos, editar informações dos veículos, efetuar vendas, listar veículos e processar webhooks de pagamento. A aplicação é desenvolvida utilizando Kotlin e Spring Boot, e pode ser executada em ambientes locais e em Kubernetes.

## Implementação
A aplicação foi implementada utilizando as seguintes tecnologias e práticas:

- **Kotlin**: Linguagem de programação principal.
- **Spring Boot**: Framework para criação de aplicações Java/Kotlin.
- **JPA (Hibernate)**: Persistência de dados.
- **H2 Database**: Banco de dados em memória para desenvolvimento.
- **MySQL**: Banco de dados de produção.
- **Flyway**: Migrações de banco de dados.
- **Docker**: Containerização da aplicação.
- **Kubernetes**: Orquestração de containers.

### Estrutura do Projeto
Opcionalmente, você pode incluir a estrutura de diretórios do projeto para ajudar novos desenvolvedores a se familiarizarem com a organização do código:


## Endpoints da API

### Veículos

- **Criar Veículo**
    - **Endpoint:** `POST /veiculos`
    - **Exemplo de Requisição:**
      ```sh
      curl -X POST http://localhost:8080/veiculos \
           -H "Content-Type: application/json" \
           -d '{
                 "marca": "Toyota",
                 "modelo": "Corolla",
                 "ano": 2020,
                 "cor": "Prata",
                 "preco": 70000,
                 "vendido": false
               }'
      ```

- **Editar Veículo**
    - **Endpoint:** `PUT /veiculos/{id}`
    - **Exemplo de Requisição:**
      ```sh
      curl -X PUT http://localhost:8080/veiculos/1 \
           -H "Content-Type: application/json" \
           -d '{
                 "marca": "Toyota",
                 "modelo": "Corolla",
                 "ano": 2020,
                 "cor": "Preto",
                 "preco": 75000,
                 "vendido": false
               }'
      ```

- **Listar Veículos**
    - **Endpoint:** `GET /veiculos`
    - **Exemplo de Requisição:**
      ```sh
      curl -X GET "http://localhost:8080/veiculos?vendido=false" -H "Content-Type: application/json"
      ```

### Vendas

- **Efetuar Venda**
    - **Endpoint:** `POST /veiculos/venda`
    - **Exemplo de Requisição:**
      ```sh
      curl -X POST http://localhost:8080/veiculos/venda \
           -H "Content-Type: application/json" \
           -d '{
                 "veiculoId": 1,
                 "cpfComprador": "12345678900",
                 "dataVenda": "2024-07-20T12:00:00",
                 "precoVenda": 75000,
                 "codigoPagamento": "abc123",
                 "statusPagamento": "PENDENTE"
               }'
      ```

### Webhooks

- **Processar Pagamento**
    - **Endpoint:** `POST /webhook/pagamento`
    - **Exemplo de Requisição:**
      ```sh
      curl -X POST "http://localhost:8080/webhook/pagamento?codigo=abc123&status=efetuado" -H "Content-Type: application/json"
      ```

## Como Rodar a Aplicação

### Requisitos
- JDK 17
- Docker
- Docker Compose (opcional)
- Kubernetes (opcional)
- Gradle (opcional, se preferir usar wrapper: `./gradlew`)

### Rodando Localmente

#### Usando Gradle

1. Clone o repositório:
   ```sh
   git clone https://github.com/seu_usuario/vehicle-sale-application.git
   cd vehicle-sale-application
   ```


2. Usando Docker:
   ```sh
   docker build -t vehicle-sale-application .
   docker-compose up
   ```
3. Acessando o Swagger:
   ```sh
   http://localhost:8080/swagger-ui.html
   ```
