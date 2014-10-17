package br.loja.dominio;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

	private List<Item> itens = new ArrayList<Item>();

	public final List<Item> getItens() {		
		return new ArrayList<Item>(this.itens) {
			private static final long serialVersionUID = 7936326982947661776L;
			
			@Override
			public boolean add(Item item) {
				throw new RuntimeException("Não é permitido adicionar itens dessa forma.");
			}
			
		};
	}

	public Double getSubTotal() {
		Double valorTotal = 0.0D;
		for (Item item : itens) {
			valorTotal += item.getProduto().getPreco() * item.getQuantidade();
		}
		return valorTotal;
	}

	public Double getTotalValorFrete() {
		Double valorTotal = 0.0D;
		for (Item item : itens) {
			valorTotal += item.getProduto().getValorFrete() * item.getQuantidade();
		}
		return valorTotal;
	}

	public Double getTotal() {
		return this.getSubTotal() + this.getTotalValorFrete();
	}

	public void adicionarProduto(Produto produto) {
		if (this.itens.contains(new Item(produto))) {
			this.itens.get(this.itens.indexOf(new Item(produto))).setQuantidade(
					this.itens.get(this.itens.indexOf(new Item(produto))).getQuantidade() + 1);
		} else {
			this.itens.add(new Item(produto));
		}
	}

}
