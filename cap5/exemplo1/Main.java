
// Engenharia de Software Moderna - Princípios de Projeto (Cap. 5)
// Prof. Marco Tulio Valente
// 
// Exemplo de conceitos básicos de OO
//
// O exemplo está em Java, mas o foco não está na sintaxe dessa 
// linguagem, mas em conceitos básicos de orientação a objetos

import java.time.Year;

// Primeiro exemplo de classe: Pessoa
// Usado para explicar os conceitos de atributos, 
// métodos, construtores e visibilidade (público e privado)

class Pessoa {
  // atributos (privados)  
  private String nome;
  private int anoNasc;

  // construtor 
  public Pessoa(String nome, int anoNasc) {
    this.nome = nome;
    this.anoNasc = anoNasc;
  }

  // método privado: somente pode ser chamado "dentro" da classe
  private int getAnoAtual() {
    return Year.now().getValue();
  }

  // método público
  public int calculaIdade() {
    return getAnoAtual() - anoNasc;
  }

}

// Classe simples, que será usada depois para explicar composição
class Departamento {
  private String nome;

  public Departamento (String nome) {
    this.nome = nome;
  }
}

// Classe usada para explicar herança e composição
// Herança: Professor "é" uma Pessoa
// Composição: Professor "tem" um Departamento    

class Professor extends Pessoa { // herança (extends)
  private String titulacao;   
  private Departamento depto;    // composição (atributo)

  public Professor(String nome, int anoNasc, String titulacao, Departamento depto) {
    super(nome, anoNasc);  // chama construtora da superclasse (Pessoa)
    this.titulacao = titulacao;  // inicializa atributos que existem apenas
    this.depto = depto;          // em Professor
  }

  public String getTitulacao() {
    return this.titulacao;
  }
}


// Classe principal do exemplo
// Cria alguns objetos e chama seus métodos
class Main {
  
  public static void main(String[] args) {
    // cria objeto da classe Pessoa e chama construtor
    Pessoa p1 = new Pessoa("João", 2012);

    // cria outro objeto da classe Pessoa
    Pessoa p2 = new Pessoa("Maria", 2002);
    
    // chama metodo público calculaIdade() de p1 e p2
    System.out.println("\nExemplo de classes e objetos:");
    System.out.println("João tem " + p1.calculaIdade() + " anos");
    System.out.println("Maria tem " + p2.calculaIdade() + " anos");

    Departamento dept = new Departamento ("Computação");
    Professor prof1 = new Professor ("José", 1982, "doutor", dept);

    System.out.println ("\nExemplo de herança e composição:");

    // chama método herdado da superclassse (Pessoa)
    System.out.println ("José tem " + prof1.calculaIdade() + " anos");

    // chama método próprio da subclasse (Professor)
    System.out.println ("José é um " + prof1.getTitulacao());
  }
}