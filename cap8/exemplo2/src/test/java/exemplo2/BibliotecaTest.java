/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
* Exemplo de Teste de um Sistema de Bibliotecas 
*
*/

package exemplo2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

public class BibliotecaTest {
  
	Biblioteca bib = new Biblioteca(new RepositorioMemoria());
  Livro livro1 = new Livro("isbn1", "ESM");
  Livro livro2 = new Livro("isbn2", "GoF");
  Livro livro3 = new Livro("isbn3", "XP");
  Usuario usuario1 = new Usuario("usu1", "Joao");
  Usuario usuario2 = new Usuario("usu2", "Maria");  
  
	@BeforeEach
	public void init() {
    bib.adicionarLivroAcervo(livro1);
    bib.adicionarLivroAcervo(livro2);
    bib.adicionarLivroAcervo(livro3);
  }  

	@Test
	public void testaEmprestimo() throws ExcecaoLivroEmprestado {
    bib.emprestarLivro(livro1, usuario1);
    bib.emprestarLivro(livro2, usuario1);
    List<Livro> emprestados = bib.livrosEmprestadosUsuario(usuario1);
    assertEquals(emprestados.size(), 2);
    assertTrue(emprestados.contains(livro1));
    assertTrue(emprestados.contains(livro2));
	}

  @Test
	public void testaEmprestimoVazio() throws ExcecaoLivroEmprestado {
    List<Livro> emprestados = bib.livrosEmprestadosUsuario(usuario1);
    assertEquals(emprestados.size(), 0);
  }
  
  @Test
  public void testaEmprestimoEDevolucao() throws ExcecaoLivroEmprestado {
    bib.emprestarLivro(livro1, usuario1);
    bib.emprestarLivro(livro2, usuario1);
    bib.receberLivroEmprestado(livro1);
    List<Livro> emprestados = bib.livrosEmprestadosUsuario(usuario1);
    assertEquals(emprestados.size(), 1);
    assertFalse(emprestados.contains(livro1));
    assertTrue(emprestados.contains(livro2));
	}
	
	@Test
	public void testaEmprestarLivrojaEmprestado() throws ExcecaoLivroEmprestado {
	  bib.emprestarLivro(livro1, usuario1);
    assertThrows(ExcecaoLivroEmprestado.class, () -> {
        bib.emprestarLivro(livro1, usuario2);
    });
	}
}