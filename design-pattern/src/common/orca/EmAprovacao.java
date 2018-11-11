package common.orca;

public class EmAprovacao implements EstadoDeOrcamento{
	@Override
	public void descontoExtra(Orcamento orcamento) {
		orcamento.desconto = orcamento.getValor()*0.1;
	}

	@Override
	public void aprova(Orcamento orcamento) {
		orcamento.estado = new Aprovado();
	}
	@Override
	public void reprova(Orcamento orcamento) {
		orcamento.estado = new Reprovado();
	}
	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Nao pode ir direto para finalizado!!");
	}
}
