/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
* Exemplo de Teste de um Sistema de Bibliotecas 
* (bem simples, apenas para fins didáticos)
* 
* Para facilitar a implementação de testes de unidade,
* o código também faz uso de alguns bons padrões de
* projeto, incluindo:
* 
* - Repositório, para abstrair a implementação de uma
*   base de dados.
* - Injeção de Dependência, pois o Repositório concreto
*   usado por um objeto da classe Biblioteca é "injetado"
*   via um parâmetro da construtora da classe.
* - Classes de serviços, que implementam métodos que têm
*   significado e importância no domínio do sistema
*/

package exemplo2;

import java.util.List;

/**
  Classe que implementa serviços típicos de uma biblioteca.
  O padrão Repositório é usado para abstrair como os dados
  são armazenados. Ou seja, a classe não sabe se eles estão
  na memória principal ou em um BD, por exemplo
*
*/
public class Biblioteca {

  private Repositorio repo;

  // injeção de dependência: implementação concreta de um
  // repositrório é injetada via construtora
  public Biblioteca (Repositorio repo) {
    this.repo = repo;
  }

  public void adicionarLivroAcervo (Livro livro) {
    repo.adicionarLivroAcervo(livro.getISBN(), livro);
  }

  public void emprestarLivro (Livro livro, Usuario usuario) throws ExcecaoLivroEmprestado {
    // como os serviços atuais são bem simples, esta é
    // a única "regar de negócio" implementada nesta classe.
    // Uma implementação real tende a possuir diversas
    // outras regras de negócio
    if (repo.livroEstaEmprestado(livro)) {
       throw new ExcecaoLivroEmprestado();
    }
    repo.emprestarLivro(livro, usuario);
  }

  public void receberLivroEmprestado (Livro livro) {
    repo.receberLivroEmprestado(livro);
  }

  public List<Livro> livrosEmprestadosUsuario (Usuario usuario) {
    return repo.livrosEmprestadosUsuario(usuario); 
  }
}