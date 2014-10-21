package br.loja.dominio;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private List<ItemPedido> itens;
	
	private Pagamento pagamento;

	private String uidCorreios;

	public Pedido(Carrinho carrinho) {
		if (carrinho.getItens().size() == 0) {
			throw new RuntimeException("Não é possível criar um pedido sem ter selecionado itens ao carrinho.");
		}
		this.itens = new ArrayList<ItemPedido>();
		for (Item itemCarrinho : carrinho.getItens()) {
			this.itens.add(new ItemPedido(itemCarrinho));
		}
	}

	public List<ItemPedido> getItens() {
		return this.itens;
	}

	public String getUidCorreios() {
		return uidCorreios;
	}

	public void setUidCorreios(String uidCorreios) {
		this.uidCorreios = uidCorreios;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
}
