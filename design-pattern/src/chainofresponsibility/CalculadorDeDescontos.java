package chainofresponsibility;

import common.orca.Orcamento;

public class CalculadorDeDescontos {
	public double calcula(Orcamento orcamento) {
		Desconto desconto1 = new DescontoPorItens();
		Desconto desconto2 = new DescontoPorValor();
		Desconto desconto3 = new SemDesconto();
		
		desconto1.setPoximo(desconto2);
		desconto2.setPoximo(desconto3);

		return desconto1.desconto(orcamento);
	}
}
