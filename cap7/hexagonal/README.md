# Exemplo de Arquitetura Hexagonal em Java

Exemplo mínimo de uma aplicação Java que segue uma Arquitetura Hexagonal, com motivação didática apenas.

## Como Executar?

Para executar a aplicação, digite no diretório ```hexagonal```:

```mvn compile```

```mvn -q exec:java```

E depois entre em um browser e digite:

http://localhost:4567

## Diagrama de Sequência

```mermaid
sequenceDiagram
    autonumber
    actor Usuario as Usuário
    participant Web as PesquisaLivrosWeb (Adaptador Web)
    participant Servico as PesquisaLivrosImpl (Domínio/Serviço)
    participant Repo as RepositorioImpl (Adaptador de BD)
    participant DB as Banco de Dados

    Usuario->>Web: GET /livros/porAutor?nome=Valente
    activate Web
    Web->>Servico: pesquisaPorAutor("Valente")
    activate Servico
    Servico->>Repo: getLivro("Valente")
    activate Repo
    Repo->>DB: SELECT * FROM livros WHERE autor="Valente"
    DB-->>Repo: Row -> Livro
    Repo-->>Servico: Livro
    deactivate Repo
    Servico-->>Web: título do Livro
    deactivate Servico
    Web-->>Usuario: 200 OK (JSON/text com título)
    deactivate Web
```
