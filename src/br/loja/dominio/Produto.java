package br.loja.dominio;

public class Produto {

	private String sku;

	private String descricao;

	private Double preco;

	public Produto(String sku, Double preco) {
		this.sku = sku;
		if (Double.compare(preco, 0.0) < 0) {
			throw new IllegalArgumentException("Não é permitido produtos com valores negativos.");
		}
		this.preco = preco;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
