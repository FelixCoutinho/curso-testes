package br.loja.dominio;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Produto {

	private String sku;

	private String descricao;

	private BigDecimal preco;

	private BigDecimal percentualFrete = BigDecimal.valueOf(0.10);

	public Produto(String sku, BigDecimal preco) {
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

	public BigDecimal getPreco() {
		return preco;
	}
	
	public String getPrecoFormatado(){
		return new DecimalFormat("R$ 0.00").format(preco);
	}

	public void setPreco(BigDecimal preco) {
		if (preco.compareTo(BigDecimal.valueOf(0)) < 0) {
			throw new IllegalArgumentException();
		}
		this.preco = preco;
	}

	public BigDecimal getPercentualFrete() {
		return percentualFrete;
	}

	public void setPercentualFrete(BigDecimal percentualFrete) {
		this.percentualFrete = percentualFrete;
	}

	public BigDecimal getValorFrete(){
		return preco.multiply(percentualFrete);
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
