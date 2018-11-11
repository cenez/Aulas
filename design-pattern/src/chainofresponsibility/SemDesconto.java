package chainofresponsibility;

import common.orca.Orcamento;

public class SemDesconto implements Desconto {

	@Override
	public double desconto(Orcamento orcamento) {
		return 0;
	}

	@Override
	public void setPoximo(Desconto proximo) {
	}
}
