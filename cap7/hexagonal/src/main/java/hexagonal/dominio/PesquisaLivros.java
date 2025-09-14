package hexagonal.dominio;

// Interface do serviço de pesquisa de livros 
// Conceitualmente, em uma Arquitetura Hexagonal, 
// essa interface é uma porta de entrada

public interface PesquisaLivros {
  String pesquisaPorAutor(String autor);
}