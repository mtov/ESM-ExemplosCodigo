package hexagonal.dominio;

// Interface usada pelo domínio para acessar o BD
// Conceitualmente, em uma Arquitetura Hexagonal, 
// essa interface é uma porta de saída

public interface Repositorio {
  public Livro getLivro(String autor);
}