/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
* Exemplo de Teste de Unidade - Classe Pilha (em JavaScript)
*
*/

const stack = require('./stack');

describe('teste da classe pilha', () => {

beforeEach(() => {
  s = new stack();
})

test('pilha vazia', () => {
  expect(s.isEmpty()).toBeTruthy();;
});

test('pilha não vazia', () => {
  s.push(5);
  expect(s.isEmpty()).toBeFalsy();
});

test('pilha com 3 elementos', () => {
  s.push(10);
  s.push(20);
  s.push(30);
  expect(s.size()).toBe(3);
});

test('pilha após desempilhar dois elementos', () => {
  s.push(10);
  s.push(20);
  s.push(30);
  s.pop()
  expect(s.pop()).toBe(20);
});

test('pilha com exceção de pilha vazia ao desempilhar', () => {
  s.push(10);
  s.pop();
  expect(() => s.pop()).toThrow();
});

})