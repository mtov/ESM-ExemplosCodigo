package hexagonal.adaptadores;

import static spark.Spark.*;
import hexagonal.dominio.PesquisaLivros;

// Oferece acesso ao sistema via Web/REST
// Usando endpoints implementados via SparkJava
// Conceitualmente, em uma Arquitetura Hexagonal, 
// essa classe é um adaptador

public class PesquisaLivrosWeb {
   PesquisaLivros pesq;

   public PesquisaLivrosWeb(PesquisaLivros pesq) {
      this.pesq = pesq;
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
        return pesq.pesquisaPorAutor(autor);
     });

     init();
     awaitInitialization();
     System.out.println("Spark rodando em http://localhost:" + port());
   }
}