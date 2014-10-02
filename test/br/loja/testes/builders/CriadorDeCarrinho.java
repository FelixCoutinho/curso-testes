package br.loja.testes.builders;

import java.util.List;

import br.loja.dominio.Carrinho;
import br.loja.dominio.Produto;

public class CriadorDeCarrinho {

	private String cep;
	
	private List<Produto> produtos;
	
	public CriadorDeCarrinho() {
	}

	public static CriadorDeCarrinho umCarrinho() {
		return new CriadorDeCarrinho();
	}

	public CriadorDeCarrinho comCep(String cep) {
		this.cep = cep;
		return this;
	}
	
	public CriadorDeCarrinho comProduto(Produto produto){
		this.produtos.add(produto);
		return this;
	}

	public Carrinho criar() {
		return new Carrinho(cep);
	}
}
