package br.loja.dominio;

import org.junit.Test;

public class TestesProduto {

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveriaAceitarProdutosComPrecoNegativo() {
		new Produto("PRD-0009", -559.99);
	}

	@Test
	public void deveriaCriarProduto() {
		new Produto("PRD-0009", 559.99);
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveriaAlterarPrecoParaNegativo() {
		Produto iPhone6 = new Produto("PRD-0001", 2399.99);
		iPhone6.setPreco(Double.valueOf(-1));
	}

}
