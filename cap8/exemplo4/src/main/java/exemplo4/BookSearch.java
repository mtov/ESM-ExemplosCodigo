/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
* Exemplo de mocks - Seção 8.6
*
*/

package exemplo4;

import org.json.JSONObject;

public class BookSearch {

  BookService rbs;

  public BookSearch(BookService rbs) {
    this.rbs = rbs;
  }

  public Book getBook(int isbn) {
    String json = rbs.search(isbn);
    JSONObject obj = new JSONObject(json);
    String titulo;
    titulo = (String)obj.get("titulo");
    return new Book(titulo);
  } 
}