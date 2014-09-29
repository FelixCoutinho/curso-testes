package br.loja.dominio;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

	public Carrinho() {
		this.itens = new ArrayList<Item>();
	}

	private List<Item> itens;

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Double getTotal() {
		Double valorTotal = Double.valueOf(0);
		for (Item item : itens) {
			valorTotal += item.getProduto().getPreco() * item.getQuantidade();
		}
		return valorTotal;
	}

	public Boolean isVazio() {
		return itens.isEmpty();
	}
}
