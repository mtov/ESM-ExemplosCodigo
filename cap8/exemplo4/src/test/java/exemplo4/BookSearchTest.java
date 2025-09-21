/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
* Exemplo de mocks - Seção 8.6
*
*/

package exemplo4;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyInt;

public class BookSearchTest {

  private BookService service;

  @BeforeEach
  public void init() {
    service = mock(BookService.class);
    when(service.search(anyInt())).
                thenReturn(BookConst.NULLBOOK);
    when(service.search(1234)).thenReturn(BookConst.ESM);
    when(service.search(5678)).thenReturn(BookConst.HP);
  }      

  @Test
  public void testGetBook() {
    BookSearch bs = new BookSearch(service);
    String titulo = bs.getBook(1234).getTitulo();
    assertEquals("Eng Soft Moderna", titulo);
  }

  @Test
  public void testGetAnotherBook() {
    BookSearch bs = new BookSearch(service);
    String titulo = bs.getBook(5678).getTitulo();
    assertEquals("Harry Potter", titulo);
  }

  @Test
  public void testGetNullBook() {
    BookSearch bs = new BookSearch(service);
    String titulo = bs.getBook(635263).getTitulo();
    assertEquals("NULL", titulo);
  }
}