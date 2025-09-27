/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
* Teste que usa um mock para testar um método estático
* Usando um recurso novo do Mockito, disponível a partir 
* da versão 3.4.0. Antes dessa versão, não era possível 
* criar mocks para métodos estáticos.
*
*/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class TesteMocksMetodosEstaticos {
  
  @Test
  public void testaMetodoEstatico() {
    assertEquals("1.0", Sistema.getVersion());
  
    // mock para método estático Sistema.getVersion()
    try (MockedStatic<Sistema> mock = Mockito.mockStatic(Sistema.class)) {
      mock.when(Sistema::getVersion).thenReturn("2.0");
      assertEquals("2.0", Sistema.getVersion());
    }
  
    assertEquals("1.0", Sistema.getVersion());
  }

}