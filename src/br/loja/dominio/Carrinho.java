package br.loja.dominio;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

	public Carrinho() {
	}

	public Carrinho(String cep) {
		this.cep = cep;
	}

	private List<Item> itens = new ArrayList<Item>();
	private String cep;

	public Carrinho adicionar(Produto produto) {
		Item item = new Item(produto);
		if (this.itens.contains(item)) {
			Item itemExistente = this.itens.get(this.itens.indexOf(item));
			itemExistente.setQuantidade(itemExistente.getQuantidade() + 1);
		} else {
			this.itens.add(item);
		}
		return this;
	}

	public List<Item> getItens() {
		if (this.itens == null || this.itens.size() == 0) {
			throw new RuntimeException("Seu carrinho está vazio!");
		}
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Double getTotal() {
		return getSubTotal() + this.getValorFrete();
	}

	public Double getSubTotal() {
		Double valorTotal = 0.0;
		for (Item item : itens) {
			valorTotal += item.getProduto().getPreco() * item.getQuantidade();
		}
		return valorTotal;
	}

	public Double getValorFrete() {
		if (this.cep != null && this.cep != "") {
			return this.getSubTotal() * 0.10;
		}
		return 0.0;
	}

	public Boolean isVazio() {
		return itens.isEmpty();
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
