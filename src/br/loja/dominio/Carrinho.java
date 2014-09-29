package br.loja.dominio;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

	public Carrinho() {
		this.itens = new ArrayList<Item>();
	}

	private List<Item> itens;
	private String cep;

	public List<Item> getItens() {
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
