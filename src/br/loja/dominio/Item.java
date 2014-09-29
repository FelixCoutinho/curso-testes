package br.loja.dominio;

public class Item {

	private Produto produto;

	private Integer quantidade;
	
	public Item(Produto produto) {
		this.produto = produto;		
		this.quantidade = 1;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
