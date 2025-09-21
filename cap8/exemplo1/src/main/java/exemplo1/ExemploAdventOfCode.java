/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
* Exemplo adaptado do desafio "Advent of Code 2020"
* https://adventofcode.com/2020/day/1
* 
* Enunciado:
* Dado um vetor de inteiros, descubra dois elementos cuja soma é 2020.
* E então retorne o produto desses dois elementos.
* Se não existir nenhum par, retornar zero.
* Se existir mais de um par, retorne o primeiro par que seu algoritmo encontrar.
*
*/

package exemplo1;

import java.util.ArrayList;
import java.util.List;

/**
* Classe que resolve o "desafio" (e que será testada)
*/

public class ExemploAdventOfCode {

  public int produtoSoma2020(int[] vetor) {
    
    List<Integer> produtos = new ArrayList<Integer>();

    for (int i = 0; i < vetor.length-1; ++i) {
      for (int j = i+1; j < vetor.length; j++) {
        if (vetor[i] + vetor[j] == 2020) {
           produtos.add(vetor[i]*vetor[j]);
          }
      }
    }  
    
    if (produtos.size() >= 1) {
       return produtos.get(0);
    }   
    else {
      return 0;
    }    
  }

}