/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
* Exemplo de teste repetido ("repeated")
*
*/
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TesteRepetido {

  // Teste repetido (será executado 5 vezes)
  // Nenhuma delas irá falhar, pois 2 é par
  // São recomendados no caso de testes flaky
  @RepeatedTest(5)
  void testaSeNumeroPar() {
    assertTrue(Calculadora.isEven(2));
  }
  
}