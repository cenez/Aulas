package observer;

import builder.NotaFiscal;

public class EnviadorDeSMS implements ObserverGerarNota{
	public void executa(NotaFiscal nota) {
		System.out.println("Enviando por sms!");
	}
}
