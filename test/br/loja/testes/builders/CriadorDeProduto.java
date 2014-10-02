package br.loja.testes.builders;

import br.loja.dominio.Produto;

public class CriadorDeProduto {

	private String descricao;
	private Double preco;
	private String sku;

	public CriadorDeProduto() {
	}

	public static CriadorDeProduto umProduto() {
		return new CriadorDeProduto();
	}

	public CriadorDeProduto comDescricao(String descricao) {
		this.descricao = descricao;
		return this;
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
		return new Produto(sku, descricao, preco);
	}
}
