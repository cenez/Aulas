package chainofresponsibility;

import common.orca.Orcamento;

public interface Desconto {
	double desconto(Orcamento orcamento);
	void setPoximo(Desconto proximo);
}
