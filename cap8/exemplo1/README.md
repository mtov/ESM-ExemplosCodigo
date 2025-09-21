# Exemplo 1: Teste de Unidade

Classes testadas neste exemplo:

* [Calculadora.java](https://github.com/mtov/ESM-ExemplosCodigo/blob/master/cap8/exemplo1/src/main/java/exemplo1/Calculadora.java):
  uma calculadora bem simples
* [Stack.java](https://github.com/mtov/ESM-ExemplosCodigo/blob/master/cap8/exemplo1/src/main/java/exemplo1/Stack.java):
  uma classe Stack, usada também no Cap. 8 do livro
* [ExemploAdventOfCode.java](https://github.com/mtov/ESM-ExemplosCodigo/blob/master/cap8/exemplo1/src/main/java/exemplo1/ExemploAdventOfCode.java):
  implementação de um dos primeiros desafios do Advent of Code 2020

Essas classes são testadas por meio dos seguintes testes de unidade:

* [TesteCalculadora.java](https://github.com/mtov/ESM-ExemplosCodigo/blob/master/cap8/exemplo1/src/test/java/exemplo1/TesteCalculadora.java)
* [StackTest.java](https://github.com/mtov/ESM-ExemplosCodigo/blob/master/cap8/exemplo1/src/test/java/exemplo1/StackTest.java)
* [TesteExemploAdventOfCode.java](https://github.com/mtov/ESM-ExemplosCodigo/blob/master/cap8/exemplo1/src/test/java/exemplo1/TesteExemploAdventOfCode.java)

## Como rodar os testes?

Basta digitar na pasta raiz (`exemplo1`):

```mvn clean test```

