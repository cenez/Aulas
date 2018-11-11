package chainofresponsibility;

import common.orca.Orcamento;

//public class DescontoPorValor { //falha2
public class DescontoPorValor implements Desconto {
	private Desconto proximo;

	public double desconto(Orcamento orcamento) {
		if(orcamento.getValor() > 1000)
			return orcamento.getValor() * 0.1;
		return proximo.desconto(orcamento);
	}

	@Override
	public void setPoximo(Desconto proximo) {
		this.proximo = proximo;
	}
}
