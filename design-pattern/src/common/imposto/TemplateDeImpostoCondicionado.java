package common.imposto;

import common.orca.Orcamento;

public abstract class TemplateDeImpostoCondicionado extends Imposto {
	
	@Override
	public double calcular(Orcamento orcamento) {
		if(excedeLimitesNo(orcamento))
			return taxaMaxima(orcamento) + calcularOutroImposto(orcamento);
		else return taxaMinima(orcamento) + calcularOutroImposto(orcamento);
	}
	
	abstract boolean excedeLimitesNo(Orcamento orcamento);
	abstract double taxaMaxima(Orcamento orcamento);
	abstract double taxaMinima(Orcamento orcamento);
}
