package builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import common.imposto.Imposto;
import common.orca.Orcamento;
import observer.ObserverGerarNota;

public class BuilderNotaFiscal {
	private String razaosocial;
	private String cnpj;
	private Orcamento orcamento;
	private Imposto imposto;
	private String observacoes;
	protected List<ObserverGerarNota> observers = new ArrayList<>();
	
	public BuilderNotaFiscal paraRazaoSocial(String razaosocial) {
		this.razaosocial = razaosocial; 
		return this;
	}
	public BuilderNotaFiscal paraCNPJ(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}
	public BuilderNotaFiscal naDataAtual() {
		return this;
	}
	public BuilderNotaFiscal paraOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
		return this;
	}
	public BuilderNotaFiscal paraImposto(Imposto imposto) {
		this.imposto = imposto;
		return this;
	}
	public BuilderNotaFiscal paraObservacoes(String observacoes) {
		this.observacoes = observacoes;
		return this;
	}
	public void addAcao(ObserverGerarNota acao) {
		observers.add(acao);
	}
	public NotaFiscal constroi() {
		NotaFiscal nota = new NotaFiscal(razaosocial, cnpj, LocalDate.now(),
				imposto, orcamento, observacoes);
		
		for (ObserverGerarNota acao : observers) {
			acao.executa(nota);
		}
		return nota;
	}
}
