# Exemplo 6: Testes Repetidos e Parametrizados

Classe que é testada no exemplo: 
[Calculadora.java](https://github.com/mtov/ESM-ExemplosCodigo/blob/master/cap8/exemplo6/src/main/java/exemplo6/Calculadora.java)

Teste Repetido: 
[TesteRepetido.java](https://github.com/mtov/ESM-ExemplosCodigo/blob/master/cap8/exemplo6/src/test/java/exemplo6/TesteRepetido.java)

Teste Parametrizado: 
[TesteParametrizado.java](https://github.com/mtov/ESM-ExemplosCodigo/blob/master/cap8/exemplo6/src/test/java/exemplo6/TesteParametrizado.java)


## Como rodar os testes?

Basta digitar na pasta raiz (`exemplo6`):

```mvn clean test```

Primeiro, o teste Rrepetido vai passar 5 vezes:

```console
[INFO] Running TesteRepetido
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.024 s - in TesteRepetido
```

Depois, o teste parametrizado irá falhar 4 vezes (para um total de 6 execuções):

```console
[INFO] Running TesteParametrizado

[ERROR] Tests run: 6, Failures: 4, Errors: 0, Skipped: 0, Time elapsed: 0.028 s <<< FAILURE! - in TesteParametrizado

[ERROR] TesteParametrizado.testaSeNumeroPar1(int)[1]  Time elapsed: 0.011 s  <<< FAILURE!

[ERROR] TesteParametrizado.testaSeNumeroPar1(int)[3]  Time elapsed: 0.001 s  <<< FAILURE!

[ERROR] TesteParametrizado.testaSeNumeroPar1(int)[5]  Time elapsed: 0.001 s  <<< FAILURE!

[ERROR] TesteParametrizado.testaSeNumeroPar2  Time elapsed: 0.001 s  <<< FAILURE!

```

