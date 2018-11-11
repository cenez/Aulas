package observer;

import builder.NotaFiscal;

public class Impressora implements ObserverGerarNota{
	public void executa(NotaFiscal nota) {
		System.out.println("Imprimindo");
	}
}
