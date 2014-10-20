package br.loja.dominio;

public class ItemPedido {

	private Integer quantidade;
	private Produto produto;

	public ItemPedido(Item itemCarrinho) {
		this.quantidade = itemCarrinho.getQuantidade();
		this.produto = itemCarrinho.getProduto();
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public Produto getProduto() {
		return this.produto;
	}

}
