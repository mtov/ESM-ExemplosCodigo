/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
* Exemplo de Teste de Unidade - Classe Stack
*
*/

package exemplo1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTest {
  Stack<Integer> stack;

  @BeforeEach
  public void init() {
	stack = new Stack<Integer>();
  }

  @Test
  public void testEmptyStack() {
	assertTrue(stack.isEmpty());
  }

  @Test
  public void testNotEmptyStack() {
	stack.push(10);
	assertFalse(stack.isEmpty());
  }

  @Test
  public void testSizeStack() {
	stack.push(10);
	stack.push(20);
	stack.push(30);
	int size = stack.size();
	assertEquals(3, size);
  }

  @Test
  public void testPushPopStack() {
	stack.push(10);
	stack.push(20);
	stack.push(30);
	int result = stack.pop();
	result = stack.pop();
	assertEquals(20, result);
  }

	
  @Test
  public void testEmptyStackException() {
	stack.push(10);
	stack.pop();
	assertThrows(java.util.EmptyStackException.class, () -> {
	  stack.pop();
    });
  }

}