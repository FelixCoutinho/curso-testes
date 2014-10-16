package br.loja.dominio;

import java.math.BigDecimal;

public class Produto {

	private String sku;

	private String descricao;

	private BigDecimal preco;

	public Produto(String sku, String descricao, BigDecimal preco) {
		this.sku = sku;
		this.descricao = descricao;
		if (preco.compareTo(BigDecimal.valueOf(0.0)) < 0) {
			throw new IllegalArgumentException("Não é permitido produtos com valores negativos.");
		}
		this.preco = preco;
	}

	public Produto(String sku, BigDecimal preco) {
		this.sku = sku;
		if (preco.compareTo(BigDecimal.valueOf(0.0)) < 0) {
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		return true;
	}

}
