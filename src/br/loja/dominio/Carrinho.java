package br.loja.dominio;

import java.math.BigDecimal;
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

	public BigDecimal getSubTotal() {
		BigDecimal valorTotal = BigDecimal.valueOf(0.0);
		for (Item item : itens) {
			valorTotal = valorTotal
					.add(item.getProduto().getPreco().multiply(BigDecimal.valueOf(item.getQuantidade())));
		}
		return valorTotal;
	}

	public BigDecimal getTotalValorFrete() {
		BigDecimal valorTotal = BigDecimal.valueOf(0.0);
		for (Item item : itens) {
			valorTotal = valorTotal.add(item.getProduto().getValorFrete()
					.multiply(BigDecimal.valueOf(item.getQuantidade())));
		}
		return valorTotal;
	}

	public BigDecimal getTotal() {
		return this.getSubTotal().add(this.getTotalValorFrete());
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
