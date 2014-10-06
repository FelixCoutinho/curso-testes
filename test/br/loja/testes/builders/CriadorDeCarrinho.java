package br.loja.testes.builders;

import java.util.ArrayList;
import java.util.List;

import br.loja.dominio.Carrinho;
import br.loja.dominio.Item;
import br.loja.dominio.Produto;

public class CriadorDeCarrinho {
	
	private String cep;

	private List<Item> itens;

	public CriadorDeCarrinho() {
		this.itens = new ArrayList<Item>();
	}

	public static CriadorDeCarrinho umCarrinho() {
		return new CriadorDeCarrinho();
	}

	public CriadorDeCarrinho comCep(String cep) {
		this.cep = cep;
		return this;
	}

	public CriadorDeCarrinho comProduto(Produto produto) {
		this.itens.add(new Item(produto));
		return this;
	}

	public Carrinho criar() {
		return new Carrinho(itens, cep);
	}
}
