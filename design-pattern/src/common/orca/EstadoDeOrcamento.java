package common.orca;

import common.orca.Orcamento;

public interface EstadoDeOrcamento {
	void descontoExtra(Orcamento orcamento);
	void aprova(Orcamento orcamento);
	void reprova(Orcamento orcamento);
	void finaliza(Orcamento orcamento);
}
