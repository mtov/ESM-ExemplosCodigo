package hexagonal;

import hexagonal.adaptadores.PesquisaLivrosWeb;
import hexagonal.adaptadores.RepositorioImpl;
import hexagonal.dominio.PesquisaLivrosImpl;

public class Main {
  public static void main(String[] args) {
    RepositorioImpl repo = new RepositorioImpl();
    PesquisaLivrosImpl pesq = new PesquisaLivrosImpl(repo);
    new PesquisaLivrosWeb(pesq).start();
  }
}