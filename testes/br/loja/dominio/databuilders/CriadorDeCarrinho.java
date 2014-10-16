package br.loja.dominio.databuilders;

import java.util.ArrayList;
import java.util.List;

import br.loja.dominio.Carrinho;
import br.loja.dominio.Produto;

public class CriadorDeCarrinho {
	private List<Produto> produtos = new ArrayList<Produto>();
	
	private CriadorDeCarrinho() {
	}

	public static CriadorDeCarrinho umCarrinho() {
		return new CriadorDeCarrinho();
	}

	public Carrinho criar() {
		Carrinho carrinho = new Carrinho();
		for (Produto produto : produtos) {
			carrinho.adicionarProduto(produto);
		}
		return carrinho;
	}

	public CriadorDeCarrinho comProduto(Produto produto) {
		this.produtos.add(produto);
		return this;
	}

}
