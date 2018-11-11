package templatemethod;

import common.orca.Orcamento;
public class IOF extends TemplateDeImpostoCondicionado {
	@Override
	public double taxaMaxima(Orcamento orcamento) {
		return orcamento.getValor() * 0.07;
	}
	@Override
	public double taxaMinima(Orcamento orcamento) {
		return orcamento.getValor() * 0.05;
	}
	@Override
	public boolean excedeLimitesNo(Orcamento orcamento) {
		return orcamento.getValor() > 1000;
	}
}
