package observer;

import builder.NotaFiscal;

public class NotaFiscalDao implements ObserverGerarNota{
	public void executa(NotaFiscal nota) {
		System.out.println("Salvando no banco");
	}
}
