# Exemplo de MVC

Exemplo mínimo de uma aplicação Java que segue uma Arquitetura MVC, com motivação didática apenas.

## Como Executar?

Digite no diretório ```mvc```:

```mvn compile```

```mvn -q exec:java```

E depois entre em um browser e digite:

http://localhost:4567

## Diagrama de Sequência

```mermaid
sequenceDiagram
    autonumber
    actor User as Navegador
    participant Main as Main
    participant Ctrl as ControladorPesquisaLivros (Controlador)
    participant Svc as ServicoPesquisaLivros (Modelo)
    participant DB as SQLite
    participant View as PaginaDadosLivro (Visao)

    rect rgb(245,245,245)
      note over User,Ctrl: Consulta por autor
      User->>Ctrl: GET /pesquisa?autor=Nome
      Ctrl->>Svc: pesquisaPorAutor(autor)
      Svc->>DB: DriverManager.getConnection("jdbc:sqlite::resource:db/bib.db")
      Svc->>DB: SELECT * FROM livros WHERE autor = ?
      DB-->>Svc: ResultSet (isbn, titulo, autor)
      Svc-->>Ctrl: new Livro(isbn, autor, titulo)
      Ctrl->>View: exibeLivro(titulo, autor, isbn)
      View-->>Ctrl: HTML (lista com dados do livro)
      Ctrl-->>User: 200 OK + HTML
    end

```

