package hexagonal.dominio;

// Classe de Domínio
// Implementa o serviço de pesquisa de livros

public class PesquisaLivrosImpl implements PesquisaLivros {
  
  Repositorio repo;

  public PesquisaLivrosImpl(Repositorio repo) {
    this.repo = repo;
  }

  public String pesquisaPorAutor(String autor) {
    return repo.getLivro(autor).getTitulo();
  }
}
