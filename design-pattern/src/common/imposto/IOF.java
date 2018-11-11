package common.imposto;

import common.orca.Orcamento;

public class IOF extends TemplateDeImpostoCondicionado {
	@Override
	double taxaMaxima(Orcamento orcamento) {
		return orcamento.getValor() * 0.07;
	}
	@Override
	double taxaMinima(Orcamento orcamento) {
		return orcamento.getValor() * 0.05;
	}
	@Override
	boolean excedeLimitesNo(Orcamento orcamento) {
		return orcamento.getValor() > 1000;
	}
}
