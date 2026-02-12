Itaú Backend Challenge – API de Transações e Estatísticas

Implementação do desafio técnico proposto pelo Itaú Unibanco.

A aplicação consiste em uma API REST desenvolvida em Java + Spring Boot, responsável por:

- Receber transações financeiras
- Armazená-las exclusivamente em memória
- Calcular estatísticas das transações ocorridas nos últimos 60 segundos


------------------------------------------------------------
SOBRE O DESAFIO
------------------------------------------------------------

O objetivo é construir uma API que:

- Siga estritamente os endpoints especificados
- Armazene dados apenas em memória (sem banco ou cache)
- Retorne estatísticas baseadas em uma janela móvel de 60 segundos
- Utilize apenas JSON para entrada e saída
- Respeite rigorosamente os códigos HTTP exigidos


------------------------------------------------------------
TECNOLOGIAS UTILIZADAS
------------------------------------------------------------

- Java 17+
- Spring Boot
- Maven
- Spring Validation


------------------------------------------------------------
ARQUITETURA
------------------------------------------------------------

Estrutura em camadas:

controller → service → repository (in-memory)

Princípios aplicados:

- Separação de responsabilidades
- Código limpo e legível
- Alta coesão
- Baixo acoplamento


------------------------------------------------------------
ENDPOINTS
------------------------------------------------------------

1) POST /transacao

Recebe uma nova transação.

Request JSON:

{
  "valor": 123.45,
  "dataHora": "2026-02-12T12:34:56.789-03:00"
}

Regras de validação:

- valor é obrigatório
- dataHora é obrigatória
- valor deve ser maior ou igual a 0
- A transação não pode ocorrer no futuro
- JSON deve estar válido

Respostas:

201 - Transação aceita
422 - Transação inválida
400 - JSON inválido


------------------------------------------------------------

2) DELETE /transacao

Remove todas as transações armazenadas.

Resposta:

200 OK


------------------------------------------------------------

3) GET /estatistica

Retorna estatísticas das transações ocorridas nos últimos 60 segundos.

Response JSON:

{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.456,
  "min": 12.34,
  "max": 123.56
}

Regras:

- Considera apenas transações da janela de 60 segundos
- Caso não existam transações no período, todos os valores retornam 0


------------------------------------------------------------
ESTRATÉGIA DE IMPLEMENTAÇÃO
------------------------------------------------------------

- Uso de OffsetDateTime para compatibilidade com ISO 8601
- Armazenamento em estrutura de dados em memória
- Filtragem dinâmica baseada em OffsetDateTime.now()
- Cálculo estatístico utilizando DoubleSummaryStatistics

Complexidade:

- Inserção: O(1)
- Cálculo: O(n), considerando apenas a janela ativa


------------------------------------------------------------
TESTES AUTOMATIZADOS
------------------------------------------------------------

O projeto contém:

- Testes unitários de service
- Testes de validação
- Testes para cenários inválidos
- Testes para ausência de transações

Os testes cobrem tanto fluxos positivos quanto negativos.


------------------------------------------------------------
EXECUTANDO O PROJETO
------------------------------------------------------------

1) Clonar o repositório

git clone https://github.com/ViiniDev/Desafio-Java-Itau-Backend.git


2) Executar aplicação

Via Maven Wrapper:

./mvnw spring-boot:run

Ou:

mvn clean install
java -jar target/*.jar

A aplicação estará disponível em:

http://localhost:8080



------------------------------------------------------------
PONTOS TÉCNICOS IMPORTANTES
------------------------------------------------------------

- 100% aderente às regras do desafio
- Nenhum banco de dados utilizado
- Nenhum cache externo
- Estritamente JSON
- Endpoints nomeados exatamente conforme especificação
- Commits separados por endpoint conforme solicitado


------------------------------------------------------------
AUTOR
------------------------------------------------------------

Vinicius Arruda
https://viinidev.com/


------------------------------------------------------------
CONSIDERAÇÕES FINAIS
------------------------------------------------------------

Projeto desenvolvido com foco em:

- Clareza arquitetural
- Precisão nas validações
- Conformidade com especificação
- Código limpo e testável
- Performance adequada para o contexto do desafio
