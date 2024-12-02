# Aplicação de Lista de Compras Domésticas

Esta é uma aplicação backend desenvolvida com **Spring Boot** e **MySQL** para gerenciar listas de compras domésticas. A aplicação permite aos usuários acompanhar os itens em estoque na casa, calcular a quantidade de cada item que precisa ser comprada para o mês atual e comparar os preços dos itens mês a mês. O sistema também se integra com uma API externa de supermercado para buscar os preços em tempo real dos itens quando são adicionados à lista de compras.

## Funcionalidades

- **Suporte Multi-Tenant**: Suporta múltiplos usuários com isolamento de dados.
- **Gerenciamento de Listas de Compras**: Criar, atualizar e visualizar listas de compras para cada mês.
- **Acompanhamento de Itens**: Adicionar itens às listas de compras e monitorar a quantidade em estoque.
- **Busca de Preço em Tempo Real**: Integração com uma API externa de supermercado para buscar preços atualizados dos itens.
- **Comparação de Preços**: Comparar os preços dos itens entre diferentes meses para verificar se houve aumento ou redução de preço.
- **Histórico de Preços**: Manter um histórico dos preços de cada item ao longo do tempo.

## Tecnologias Usadas

- **Spring Boot**: Framework backend para construção da aplicação.
- **MySQL**: Banco de dados para armazenar as listas de compras, itens e histórico de preços.
- **JPA/Hibernate**: Usado para ORM (Mapeamento Objeto-Relacional) e interação com o banco de dados MySQL.
- **Spring Security**: Para suporte de segurança e autenticação de multi-tenant.
- **Integração com API Externa**: Busca os preços dos itens a partir de uma API externa de supermercado.
- **Spring Data JPA**: Padrão de repositório para acesso aos dados.


## Instalação

### Pré-requisitos

- **Java 11** ou superior
- **MySQL** instalado e rodando
- **Maven** 

### Clonar o Repositório

```bash
git clone https://github.com/seuusuario/household-shopping-list.git
cd household-shopping-list
