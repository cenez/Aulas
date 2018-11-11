package strategy;

import chainofresponsibility.Item;
import common.orca.Orcamento;
import common.imposto.ICMS;
import common.imposto.ISS;
import common.imposto.Imposto;

public class Main {
	public static void main(String[] args) {
		Imposto iss = new ISS();
		Imposto icms = new ICMS();
		
		Orcamento orcamento = new Orcamento();
		orcamento.adicionaItem(new Item("Bolsa escolar", 300.0));
		orcamento.adicionaItem(new Item("Tablet escolar", 700.0));
		orcamento.adicionaItem(new Item("Caneta escolar", 5.0));
		
		System.out.println(orcamento.getValor());
		
		CalculadorDeImposto calculaImposto = new CalculadorDeImposto();
		calculaImposto.realizarCalculo(orcamento, iss);
		calculaImposto.realizarCalculo(orcamento, icms);
		
	}
}
