package chainofresponsibility;

import common.orca.Orcamento;

public class Main {
	public static void main(String[] args) {
		CalculadorDeDescontos descontos = new CalculadorDeDescontos();
		Orcamento orcamento = new Orcamento(1005);
		orcamento.adicionaItem(new Item("Bolsa escolar", 300.0));
		orcamento.adicionaItem(new Item("Tablet escolar", 700.0));
		orcamento.adicionaItem(new Item("Caneta escolar", 5.0));
		
		double descontoTotal = descontos.calcula(orcamento);
		System.out.println(descontoTotal);
		
		//Corrigir para dar o maior desconto, bem como para sincronizar valor dado no contrutor com os valores dos itens
	}
}
