package common.orca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chainofresponsibility.Item;

public class Orcamento {
	protected double desconto = 0;
	private final List<Item> itens;
	protected EstadoDeOrcamento estado;
	
	public Orcamento() {
		itens = new ArrayList<Item>();
		this.estado = new EmAprovacao();
	}
	public Orcamento(double valor) {
		this();
		for(int i=0; i<5;i++) {
			itens.add(new Item("Item."+i, (valor/5)));
		}
	}
	public void descontoExtra() {
		estado.descontoExtra(this);
	}
	public void aprova() {
		this.estado.aprova(this);
	}
	public void reprova() {
		this.estado.reprova(this);
	}
	public void finaliza() {
		this.estado.finaliza(this);
	}
	public double getValor() {
		double soma = 0;
		for (Item item : itens) {
			soma += item.getValor();
		}
		double total = (soma-desconto);
		return total>=0?total:0;
	}
	public void adicionaItem(Item item) { itens.add(item); }
	public List<Item> getItens() {
		return Collections .unmodifiableList(itens);
	}
}
