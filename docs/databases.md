# Estrutura do Banco de Dados

## Entidades e Relacionamentos

### Tabela: `usuarios`
| Campo          | Tipo       | Descrição                |
|----------------|------------|--------------------------|
| `id`           | Inteiro    | Chave primária           |
| `nome`         | Texto      | Nome do usuário          |
| `email`        | Texto      | Email único              |
| `senha`        | Texto      | Senha criptografada      |

### Tabela: `transacoes`
| Campo          | Tipo       | Descrição                |
|----------------|------------|--------------------------|
| `id`           | Inteiro    | Chave primária           |
| `tipo`         | Texto      | Receita ou Despesa       |
| `valor`        | Decimal    | Valor da transação       |
| `categoria`    | Texto      | Categoria da transação   |
| `data`         | Data       | Data da transação        |
| `id_usuario`   | Inteiro    | Relaciona ao usuário     |

### Relacionamentos
- Cada transação pertence a um usuário.
