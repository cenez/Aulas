package builder;

import java.time.LocalDate;

import common.imposto.Imposto;
import common.orca.Orcamento;

public class NotaFiscal {
	private String razaosocial;
	private String cnpj;
	private LocalDate emissao;
	private double valorBruto;
	private double total_impostos;
	private Imposto imposto;
	private String observacoes;
	private Orcamento orcamento;
	
	public NotaFiscal(String razaosocial, String cnpj, LocalDate emissao, 
			Imposto imposto, Orcamento orcamento, String observacoes) {
		this.razaosocial = razaosocial;
		this.cnpj = cnpj;
		this.emissao = emissao;
		this.imposto = imposto;
		this.orcamento = orcamento;
		this.observacoes = observacoes;
		this.total_impostos = imposto.calcular(orcamento);
		this.valorBruto = orcamento.getValor();
	}
	
	public String getRazaosocial() {
		return razaosocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public LocalDate getEmissao() {
		return emissao;
	}
	public double getValorBruto() {
		return valorBruto;
	}
	public double getTotal_impostos() {
		return total_impostos;
	}
	public Imposto getImposto() {
		return imposto;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public Orcamento getOrcamento() {
		return orcamento;
	}

	@Override
	public String toString() {
		return "NotaFiscal("+System.lineSeparator()+
				"  razaosocial=" + razaosocial + System.lineSeparator()+
				"  cnpj=" + cnpj + System.lineSeparator()+
				"  emissao=" + emissao + System.lineSeparator()+
				"  valorBruto=" + valorBruto + System.lineSeparator()+
				"  total_impostos=" + total_impostos + System.lineSeparator()+
				"  observacoes=" + observacoes + System.lineSeparator()+
				")";
	}
}
