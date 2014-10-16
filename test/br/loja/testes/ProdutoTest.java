package br.loja.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.loja.dominio.Produto;

public class ProdutoTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveAceitarProdutosComValoresNegativos() {
		new Produto("PRD-0001", -0.99);
	}

	@Test
	public void deveriaFormatarPrecoComPadraoBrasileiro() {
		assertEquals("A formatação do preço não corresponde com o padrão pt-BR.", "19,99",  new Produto("PRD-0001", 19.99).getPreco().toString());
	}
}
