package br.loja.dominio;

import java.text.DecimalFormat;

public class Produto {

	private String sku;

	private String descricao;

	private Double preco;

	private Double percentualFrete = 0.10;

	public Produto(String sku, Double preco) {
		this.setSku(sku);
		this.setPreco(preco);
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
	
	public String getPrecoFormatado(){
		return new DecimalFormat("R$ 0.00").format(preco);
	}

	public void setPreco(Double preco) {
		if (preco < 0) {
			throw new IllegalArgumentException();
		}
		this.preco = preco;
	}

	public Double getPercentualFrete() {
		return percentualFrete;
	}

	public void setPercentualFrete(Double percentualFrete) {
		this.percentualFrete = percentualFrete;
	}

	public Double getValorFrete(){
		return preco * percentualFrete;
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
