package templatemethod;

import chainofresponsibility.Item;
import common.orca.Orcamento;
public class IPI extends TemplateDeImpostoCondicionado {
	@Override
	public double taxaMaxima(Orcamento orcamento) {
		return orcamento.getValor() * 0.1;
	}
	@Override
	public double taxaMinima(Orcamento orcamento) {
		return orcamento.getValor() * 0.08;
	}
	
	@Override
	public boolean excedeLimitesNo(Orcamento orcamento) {
		return orcamento.getValor() > 1000 && temItemComValorSignificativoNo(orcamento);
	}
	private boolean temItemComValorSignificativoNo(Orcamento orcamento) {
		for (Item item : orcamento.getItens()) {
			if(item.getValor() >= 500) return true;
		}
		return false;
	}
}
