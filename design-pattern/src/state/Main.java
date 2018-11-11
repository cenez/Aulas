package state;

import chainofresponsibility.Item;
import common.orca.Orcamento;

public class Main {
	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento();
		
		orcamento.adicionaItem(new Item("Bolsa escolar", 100.0));
		orcamento.adicionaItem(new Item("Tablet escolar", 700.0));
		orcamento.adicionaItem(new Item("Caneta escolar", 5.0));

		System.out.println("Sem desconto: "+orcamento.getValor());
		
		orcamento.descontoExtra();
		
		System.out.println("Desconto EmAprovacao: "+orcamento.getValor());
		orcamento.aprova();
		orcamento.descontoExtra();
		System.out.println("Resultado: "+orcamento.getValor());
	}
}
