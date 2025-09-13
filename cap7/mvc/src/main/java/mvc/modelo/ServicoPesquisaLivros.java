package mvc.modelo;

import java.sql.*;

public class ServicoPesquisaLivros {

  public Livro pesquisaPorAutor(String autor) {
    try(Connection con = DriverManager.getConnection("jdbc:sqlite::resource:db/bib.db")) {
       String query = "select * from livros where autor = ?"; 
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
