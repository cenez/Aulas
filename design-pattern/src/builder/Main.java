package builder;

import chainofresponsibility.Item;
import common.imposto.ICMS;
import common.imposto.IPI;
import common.imposto.ISS;
import common.imposto.Imposto;
import common.orca.Orcamento;
import observer.EnviadorDeEmail;
import observer.EnviadorDeSMS;
import observer.Impressora;
import observer.NotaFiscalDao;

public class Main {
	public static void main(String[] args) {
		Imposto imposto = new ISS(new ICMS(new IPI()));

		Orcamento orcamento = new Orcamento();
		orcamento.adicionaItem(new Item("Bolsa escolar", 995.0));
		orcamento.adicionaItem(new Item("Tablet escolar", 4000.0));
		orcamento.adicionaItem(new Item("Caneta escolar", 5.0));
		
		BuilderNotaFiscal builder = new BuilderNotaFiscal();
		builder.paraRazaoSocial("Joao da silva representacoes")
		  .paraCNPJ("1234567")
		  .naDataAtual()
		  .paraOrcamento(orcamento)
		  .paraImposto(imposto)
		  .paraObservacoes("Produtos escolares");
		
		builder.addAcao(new EnviadorDeEmail());
		builder.addAcao(new EnviadorDeSMS());
		builder.addAcao(new NotaFiscalDao());
		builder.addAcao(new Impressora());
		
		System.out.println(builder.constroi());
	}
}
