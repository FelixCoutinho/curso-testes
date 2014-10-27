package br.loja.dominio;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Integer id;

	@Column(name = "sku")
	private String sku;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "preco")
	private BigDecimal preco;

	private BigDecimal percentualFrete = BigDecimal.valueOf(0.10);

	public Produto(String sku, BigDecimal preco) {
		this.setSku(sku);
		this.setPreco(preco);
	}

	public void setSku(String sku) {
		this.sku = sku;
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

	public BigDecimal getValorFrete(){
		return preco.multiply(percentualFrete);
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
