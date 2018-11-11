package strategy;

import common.orca.Orcamento;
import common.imposto.Imposto;

public class CalculadorDeImposto {
	public void realizarCalculo(Orcamento orcamento, Imposto imposto) {
		System.out.println("Imposto devido: "+imposto.calcular(orcamento));
	}
}
