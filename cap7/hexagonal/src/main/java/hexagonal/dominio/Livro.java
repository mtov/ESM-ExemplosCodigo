package hexagonal.dominio;

// Na terminologia de DDD, a classe Livro seria uma Entidade
// O mesmo vale para a terminologia de Arquitetura Limpa

public class Livro {
  private String isbn;
  private String autor;
  private String titulo;

  public Livro(String isbn, String autor, String titulo) {
    this.isbn = isbn;
    this.autor = autor;
    this.titulo = titulo;
  }

  public String getISBN() {
    return this.isbn;
  }

  public String getAutor() {
    return this.autor;
  }

  public String getTitulo() {
    return this.titulo;
  }
}