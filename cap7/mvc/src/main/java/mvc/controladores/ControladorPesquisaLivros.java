package mvc.controladores;

import static spark.Spark.*;
import mvc.modelo.*;
import mvc.visao.*;

public class ControladorPesquisaLivros {
  ServicoPesquisaLivros pesq;
  PaginaDadosLivro pagina; 

  public ControladorPesquisaLivros(ServicoPesquisaLivros pesq, PaginaDadosLivro pagina) {
    this.pesq = pesq;
    this.pagina = pagina;
   }
  
  public void start() {
    port(4567);
  
    staticFiles.location("/static");
        
    get("/", (req, res) -> { 
       res.redirect("index.html");
       return null;
    });

    get("/pesquisa", (req, res) -> { 
       String autor = req.queryParams("autor");
       Livro livro = pesq.pesquisaPorAutor(autor);
       return pagina.exibeLivro(livro.getTitulo(), livro.getAutor(), livro.getISBN());
    });

    init();
    awaitInitialization();
    System.out.println("Spark rodando em http://localhost:" + port());
   }
}