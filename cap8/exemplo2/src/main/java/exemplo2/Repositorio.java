/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
*
*/

package exemplo2;

import java.util.List;

/**
  Métodos que obrigatoriamente devem existir em qualquer
  repositório
*/  

interface Repositorio {
  public void adicionarLivroAcervo (String isbn, Livro livro);
  public boolean livroEstaEmprestado (Livro livro);
  public void emprestarLivro (Livro livro, Usuario usuario);
  public void receberLivroEmprestado (Livro livro);
  public List<Livro> livrosEmprestadosUsuario (Usuario usuario);
}