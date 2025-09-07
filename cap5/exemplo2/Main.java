// Engenharia de Software Moderna - Princípios de Projeto (Cap. 5)
// Prof. Marco Tulio Valente
// 
// Exemplo de conceitos básicos de OO: Interfaces
//
// O exemplo está em Java, mas o foco não está na sintaxe dessa 
// linguagem, mas em conceitos básicos de orientação a objetos

// O exemplo simula o processamento do pagamento das assinaturas 
// de um sistema SaaS (Software as a Service), isto é, um sistema 
// que requer o pagamento de uma assinatura mensal.


// Interface do processador (gateway) de pagamento

interface GatewayPagamento {
  void processaPagto(String descricao, double valor);
}

// Classe que implementa a interface GatewayPagamento (acima)
// Ou seja, esta classe implementa o método processaPagto
// No caso, apenas simulamos o pagamento via PayPal
// Em um sistema real, teríamos que usar a API do PayPal para,
// de fato, efetivar o débito

class PagamentoPayPal implements GatewayPagamento {

  public void processaPagto(String descricao, double valor) {
    // apenas simula pagamento, imprimindo seus dados na tela
    System.out.println("\nDebitando Paypal");
    System.out.println("Cliente: " + descricao + " - R$ " + valor);
  }
}

// Classe com dados dos clientes assinantes do sistema SaaS
// Será usada pela próxima classe, a qual implementa o débito das assinaturas

class Cliente {
  private String nome;
  private double assinatura;
  private double desconto;

  public Cliente(String nome, double assinatura, double desconto) {
    this.nome = nome;
    this.assinatura = assinatura;
    this.desconto = desconto;
  }

  public String getNome() {
    return this.nome;
  }

  public double getValorAssinatura() {
    return this.assinatura * (1 - this.desconto);
  }
}

// Classe que implementa as rotinas de pagamento, incluindo a rotina que
// debita as assinaturas de uma lista de clientes.
// IMPORTANTE: como usa a interface GatewayPagamentos para processar os
// pagamentos, essa classe não conhece o serviço de pagamento real que 
// está usando (no nosso exemplo, o PayPal).
// VANTAGEM: se mudarmos de serviço de pagamento, não precisaremos mudar
// nada na classe abaixo

class ServicoPagamentos {
  private GatewayPagamento gateway;   // GatewayPagamento é uma interface
  
  public ServicoPagamentos (GatewayPagamento gateway) {
    this.gateway = gateway;
  }
  
  public void debitarAssinaturas (Cliente[]  listaClientes) {
    for (Cliente cliente: listaClientes) {
      gateway.processaPagto(cliente.getNome(), cliente.getValorAssinatura());
    }
  }
}

class Main {
  public static void main(String[] args) {
    Cliente c1 = new Cliente ("José", 100, 0.05);
    Cliente c2 = new Cliente ("Maria", 100, 0.15);
    Cliente c3 = new Cliente ("Manoel", 100, 0.0 );
    Cliente [] listaClientes = { c1, c2, c3 };
      
    GatewayPagamento gateway = new PagamentoPayPal();
    ServicoPagamentos servico = new ServicoPagamentos(gateway);

    servico.debitarAssinaturas(listaClientes);
  }
}
