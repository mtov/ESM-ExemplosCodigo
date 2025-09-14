package hexagonal.adaptadores;

import java.sql.*;
import hexagonal.dominio.Repositorio;
import hexagonal.dominio.Livro;


// Implementa acesso ao sistema de banco de dados
// Conceitualmente, em uma Arquitetura Hexagonal, 
// essa interface é um adaptador

public class RepositorioImpl implements Repositorio {
  
  public Livro getLivro(String autor) {
    try(Connection con = DriverManager.getConnection("jdbc:sqlite::resource:db/bib.db")) {       String query = "select * from livros where autor = ?"; 
       PreparedStatement stmt = con.prepareStatement(query);
       stmt.setString(1, autor);
       ResultSet rs = stmt.executeQuery();
       String isbn = rs.getString("isbn");
       String titulo = rs.getString("titulo");
       return new Livro(isbn, autor, titulo);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      return null;
    } 
  }       

}