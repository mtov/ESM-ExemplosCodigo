package mvc;

import mvc.controladores.*;
import mvc.modelo.*;
import mvc.visao.*;

public class Main {
  public static void main(String[] args) {
    new ControladorPesquisaLivros(
          new ServicoPesquisaLivros(),   // classe do Modelo
          new PaginaDadosLivro()         // classe da Visao      
        ).start();
  }
}