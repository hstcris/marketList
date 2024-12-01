# Aplicação de Lista de Compras Domésticas

Esta é uma aplicação backend desenvolvida com **Spring Boot** e **MySQL** para gerenciar listas de compras domésticas. A aplicação permite aos usuários acompanhar os itens em estoque na casa, calcular a quantidade de cada item que precisa ser comprada para o mês atual e comparar os preços dos itens mês a mês. O sistema também se integra com uma API externa de supermercado para buscar os preços em tempo real dos itens quando são adicionados à lista de compras.

## Funcionalidades

- **Suporte Multi-Tenant**: Suporta múltiplos usuários (famílias), com isolamento de dados.
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

## Estrutura do Banco de Dados

### `purchase_list` (Lista de Compras)
- `id`: Identificador único da lista de compras.
- `date`: Data da lista de compras (por exemplo, o mês da lista).
- `tenant_id`: Identificador único do usuário/família.

### `purchase_item` (Item da Compra)
- `id`: Identificador único do item.
- `name`: Nome do item (por exemplo, "maçã", "leite").
- `quantity_in_stock`: Quantidade de itens atualmente no estoque.
- `quantity_to_buy`: Quantidade de itens necessária para o mês.
- `purchase_list_id`: Chave estrangeira que referencia a tabela `purchase_list`.

### `price_history` (Histórico de Preço)
- `id`: Identificador único do registro de preço.
- `price`: Preço do item.
- `date`: Data do registro de preço.
- `purchase_item_id`: Chave estrangeira que referencia a tabela `purchase_item`.

## Instalação

### Pré-requisitos

- **Java 11** ou superior
- **MySQL** instalado e rodando
- **Maven** ou **Gradle** (dependendo da ferramenta de build que você utiliza)

### Clonar o Repositório

```bash
git clone https://github.com/seuusuario/household-shopping-list.git
cd household-shopping-list
