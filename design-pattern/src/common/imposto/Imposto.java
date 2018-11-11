package common.imposto;

import common.orca.Orcamento;

public abstract class Imposto {
	protected Imposto outroImposto;
	
	public Imposto() { }
	public Imposto(Imposto imposto) {
		this();
		this.outroImposto = imposto;
	}
	public abstract double calcular(Orcamento orcamento);
	protected double calcularOutroImposto(Orcamento orcamento) {
		if(this.outroImposto == null) return 0;
		return this.outroImposto.calcular(orcamento);
	}
}
