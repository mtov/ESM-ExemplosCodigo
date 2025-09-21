// Na terminologia de DDD (e também de Arquitetura Limpa)
// a classe Livro é um exemplo de entidade

package exemplo2;

public class Livro {
  private String isbn;
  private String nome;
  
  public Livro(String isbn, String nome) {
    this.isbn = isbn;
    this.nome = nome;
  }

  public String getISBN() {
    return isbn;
  }
}
