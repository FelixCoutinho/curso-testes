package br.loja.dominio;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private List<ItemPedido> itens;

	public Pedido(Carrinho carrinho) {
		if(carrinho.getItens().size() == 0){
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

}
