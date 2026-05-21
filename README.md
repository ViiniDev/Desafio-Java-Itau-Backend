# Desafio Java Itaú Backend

API REST desenvolvida em Java com Spring Boot para resolver o desafio técnico de transações e estatísticas. A aplicação recebe transações financeiras, mantém os dados em memória e calcula estatísticas das transações realizadas nos últimos 60 segundos.

## Objetivo

Construir uma API aderente às regras do desafio, com entrada e saída em JSON, armazenamento em memória e respostas HTTP compatíveis com os cenários de sucesso e validação.

## Funcionalidades

- Cadastro de transações financeiras.
- Remoção de todas as transações armazenadas.
- Cálculo de estatísticas em janela móvel de 60 segundos.
- Validação de transações futuras e valores negativos.
- Armazenamento em memória, sem banco de dados.

## Tecnologias

- Java 17
- Spring Boot 4.0.2
- Spring Web MVC
- Bean Validation
- Maven

## Estrutura do Projeto

```text
src/main/java/desafio/itau/springboot
├── controller
│   ├── StatisticsController.java
│   └── TransactionController.java
├── dto
│   ├── StatisticsDTO.java
│   └── TransactionDTO.java
├── model
│   └── Transaction.java
├── service
│   └── TransactionService.java
└── SpringbootApplication.java
```

## Como Executar

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

A aplicação ficará disponível em:

```text
http://localhost:8080
```

## Endpoints

### Criar transação

```http
POST /transacao
```

```json
{
  "valor": 123.45,
  "dataHora": "2026-02-12T12:34:56.789-03:00"
}
```

Respostas:

- `201 Created`: transação aceita.
- `422 Unprocessable Entity`: transação com valor negativo ou data futura.
- `400 Bad Request`: JSON inválido ou campos ausentes.

### Limpar transações

```http
DELETE /transacao
```

Resposta:

- `200 OK`

### Consultar estatísticas

```http
GET /estatistica
```

Exemplo de resposta:

```json
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.456,
  "min": 12.34,
  "max": 123.56
}
```

Quando não houver transações nos últimos 60 segundos, todos os valores retornam `0`.

## Regras de Negócio

- Transações são armazenadas apenas em memória.
- Apenas transações dos últimos 60 segundos entram no cálculo estatístico.
- Transações futuras são recusadas.
- Valores negativos são recusados.
- Valores iguais a zero são aceitos.

## Melhorias Futuras

- Adicionar testes unitários específicos para a janela de 60 segundos.
- Criar tratamento global de exceções para padronizar respostas.
- Adicionar documentação OpenAPI.
- Adicionar pipeline de CI para execução automática dos testes.
