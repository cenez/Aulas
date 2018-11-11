package decorator;

import chainofresponsibility.Item;
import common.orca.Orcamento;
import common.imposto.*;
public class Main {
	public static void main(String[] args) {
		Imposto imposto = new ISS(new ICMS(new IPI()));

		Orcamento orcamento = new Orcamento();
		orcamento.adicionaItem(new Item("Bolsa escolar", 995.0));
		orcamento.adicionaItem(new Item("Tablet escolar", 4000.0));
		orcamento.adicionaItem(new Item("Caneta escolar", 5.0));
		
		double valor = imposto.calcular(orcamento);
		
		System.out.println(valor);

	}
}
