# Exemplo 5: Teste com Mocks de Métodos Estáticos

Teste que usa um mock para testar um método estático. Para isso, utiliza-se um recurso novo do Mockito, disponível a partir 
da versão 3.4.0. Antes dessa versão, não era possível criar mocks para métodos estáticos.

Classe que é testada no exemplo: 
[Sistema.java](https://github.com/mtov/ESM-ExemplosCodigo/blob/master/cap8/exemplo5/src/main/java/exemplo5/Sistema.java)

Teste de unidade: 
[Teste.java](https://github.com/mtov/ESM-ExemplosCodigo/blob/master/cap8/exemplo5/src/test/java/exemplo5/Teste.java)

## Como rodar os testes?

Basta digitar na pasta raiz (`exemplo5`):

```mvn clean test```
