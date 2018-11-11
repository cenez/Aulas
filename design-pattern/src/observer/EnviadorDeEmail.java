package observer;

import builder.NotaFiscal;

public class EnviadorDeEmail implements ObserverGerarNota{
	public void executa(NotaFiscal nota) {
		System.out.println("Enviando por email...");
	}
}
