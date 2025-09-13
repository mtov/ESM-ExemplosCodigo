package mvc.visao;

public class PaginaDadosLivro {

  public String exibeLivro(String titulo, String autor, String isbn) {
    
    String res = "<h4> Dados do Livro Pesquisado </h4>";
    res += "<ul>";
    res += "<li> Título: " + titulo + " </li>";
    res += "<li> Autor: " + autor + " </li>";
    res += "<li> ISBN: " + isbn + " </li>";
    res += "</ul>";
    return res;
  }
}  