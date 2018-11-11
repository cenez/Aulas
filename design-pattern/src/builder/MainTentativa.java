package builder;

import java.util.List;

import chainofresponsibility.Item;
import common.imposto.ICMS;
import common.imposto.IPI;
import common.imposto.ISS;
import common.imposto.Imposto;
import common.orca.Orcamento;

public class MainTentativa {
	public static void main(String[] args) {
		Imposto imposto = new ISS(new ICMS(new IPI()));

		Orcamento orcamento = new Orcamento();
		orcamento.adicionaItem(new Item("Bolsa escolar", 995.0));
		orcamento.adicionaItem(new Item("Tablet escolar", 4000.0));
		orcamento.adicionaItem(new Item("Caneta escolar", 5.0));
		List<Item> itens = orcamento.getItens();
		
		double valorBruto = imposto.calcular(orcamento);
		
//		NotaFiscal nota = new NotaFiscal(
//				"Joao da silva representacoes",
//				"1234567",
//				LocalDate.now(), 
//				orcamento.getValor(), 
//				valorBruto, 
//				itens,
//				"Produtos escolares"
//				);
	}
}
