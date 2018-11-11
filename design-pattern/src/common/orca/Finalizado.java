package common.orca;

public class Finalizado implements EstadoDeOrcamento{
	@Override
	public void descontoExtra(Orcamento orcamento) {
		throw new RuntimeException("Sem desconto extra, já finalizado!");
	}
	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Ja finalizado!!");
	}
	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Ja finalizado!!");
	}
	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Ja finalizado!!");
	}

}
