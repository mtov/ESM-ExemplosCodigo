/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
* Exemplo de teste parametrizado
*
*/

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
 
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TesteParametrizado {

  // teste parametrizado
  // ele será chamado 5 vezes pelo framework de teste
  // irá falhar para n = 1, 3, e 5
  // parâmetros de cada chamada são informados explicitamente (@ValueSource)
  @ParameterizedTest
  @ValueSource(ints = { 1, 2, 3, 4, 5 })
  void testaSeNumeroPar1(int n) {
    assertTrue(Calculadora.isEven(n));
  }

  // teste não-parametrizado
  @Test
  void testaSeNumeroPar2() {
    assertTrue(Calculadora.isEven(1));  

    // como o assert anterior vai falhar
    // na prática, os próximos assert não serão executados
    assertTrue(Calculadora.isEven(2));
    assertTrue(Calculadora.isEven(3));
    assertTrue(Calculadora.isEven(4));
    assertTrue(Calculadora.isEven(5));
  }
  
}