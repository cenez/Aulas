package chainofresponsibility;

import common.orca.Orcamento;

//public class DescontoPorItens { //falha2
public class DescontoPorItens implements Desconto{
	private Desconto proximo;
	public double desconto(Orcamento orcamento) {
		if(orcamento.getItens().size() >= 3)
			return orcamento.getValor() * 0.05;
		else 
			return proximo.desconto(orcamento);
	}

	@Override
	public void setPoximo(Desconto proximo) {
		this.proximo = proximo;
	}
}
