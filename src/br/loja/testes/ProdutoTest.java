package br.loja.testes;

import org.junit.Test;

import br.loja.dominio.Produto;

public class ProdutoTest {

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveAceitarProdutosComValoresNegativos() {
		new Produto("PRD-0001", -0.99);
	}
}
