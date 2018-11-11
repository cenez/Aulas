package common.orca;

public class Aprovado implements EstadoDeOrcamento{
	@Override
	public void descontoExtra(Orcamento orcamento) {
		orcamento.desconto = orcamento.getValor()*0.2;
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Ja aprovado!!");
	}
	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Nao pode reprovar depois de aprovar!!");
	}
	@Override
	public void finaliza(Orcamento orcamento) {
		orcamento.estado = new Finalizado();
	}
}
