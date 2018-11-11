package templatemethod;

import common.orca.Orcamento;
import common.imposto.Imposto;

public abstract class TemplateDeImpostoCondicionado extends Imposto {
	
	@Override
	public double calcular(Orcamento orcamento) {
		if(excedeLimitesNo(orcamento))
			return taxaMaxima(orcamento);
		else return taxaMinima(orcamento);
	}
	
	public abstract boolean excedeLimitesNo(Orcamento orcamento);
	public abstract double taxaMaxima(Orcamento orcamento);
	public abstract double taxaMinima(Orcamento orcamento);
}
