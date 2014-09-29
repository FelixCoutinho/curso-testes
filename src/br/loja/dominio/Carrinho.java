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
		Double valorTotal = Double.valueOf(0);
		for (Item item : itens) {
			valorTotal += item.getProduto().getPreco() * item.getQuantidade();
		}
		return valorTotal;
	}

	public Double getValorFrete() {
		if (this.cep != null && this.cep != "") {
			return this.getSubTotal() * Double.valueOf(0.10);
		}
		return Double.valueOf(0);
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
