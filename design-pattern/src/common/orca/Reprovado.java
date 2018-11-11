package common.orca;

public class Reprovado implements EstadoDeOrcamento{
	@Override
	public void descontoExtra(Orcamento orcamento) {
		throw new RuntimeException("Sem desconto, ja reprovado!");
	}
	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Nao pode aprovar ja reprovado!!");
	}
	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Nao pode reprovar novamente!!");
	}
	@Override
	public void finaliza(Orcamento orcamento) {
		orcamento.estado = new Finalizado();
	}
}
