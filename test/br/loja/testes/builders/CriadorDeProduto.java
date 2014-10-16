package br.loja.testes.builders;

import java.math.BigDecimal;

import br.loja.dominio.Produto;

public class CriadorDeProduto {

	private String descricao;
	private BigDecimal preco;
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

	public CriadorDeProduto comPreco(BigDecimal preco) {
		this.preco = preco;
		return this;
	}

	public Produto criar() {
		return new Produto(sku, descricao, preco);
	}
}
