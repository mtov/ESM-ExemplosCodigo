/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
*/

package exemplo2;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
  Implementação de um um repositório em memória
  
  Em vez de acessar um BD real, todos os dados
  estão em memória principal, sendo armazenados em HashMaps.
  
  Esse repositório será usado pelos testes de
  de unidade, pois eles têm que rodar rapidamente.
*/ 

class RepositorioMemoria implements Repositorio {
  
  private Map<String, Livro> acervo;
  private Map<Livro, Usuario> emprestimos;

  public RepositorioMemoria (){
    acervo = new HashMap<String,Livro>();
    emprestimos = new HashMap<Livro, Usuario>();
  }
  
  public void adicionarLivroAcervo (String isbn, Livro livro) {
    acervo.put(livro.getISBN(), livro);
  }
  
  public boolean livroEstaEmprestado (Livro livro) {
    return emprestimos.containsKey(livro);
  }
  
  public void emprestarLivro (Livro livro, Usuario usuario) {
    emprestimos.put(livro, usuario);
  }
  
  public void receberLivroEmprestado (Livro livro) {
    emprestimos.remove(livro);
  }

  public List<Livro> livrosEmprestadosUsuario (Usuario usuario) {
    return emprestimos.entrySet().stream()
                      .filter(e -> e.getValue() == usuario)
                      .map(Map.Entry::getKey)
                      .collect(Collectors.toList());
  }
}
