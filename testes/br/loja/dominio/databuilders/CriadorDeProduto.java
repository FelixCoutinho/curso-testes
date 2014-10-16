package br.loja.dominio.databuilders;

import br.loja.dominio.Produto;

public class CriadorDeProduto {

	private Double preco = 0.01;
	private String sku = "PRD-0000";

	private CriadorDeProduto() {
	}

	public static CriadorDeProduto umProduto() {
		return new CriadorDeProduto();
	}

	public CriadorDeProduto comSKU(String sku) {
		this.sku = sku;
		return this;
	}

	public CriadorDeProduto comPreco(Double preco) {
		this.preco = preco;
		return this;
	}

	public Produto criar() {
		return new Produto(sku, preco);
	}

}
