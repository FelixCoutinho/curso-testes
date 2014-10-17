package br.loja.dominio;

import java.math.BigDecimal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestesProduto {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void naoDeveriaAceitarProdutosComPrecoNegativo() {
		thrown.expect(IllegalArgumentException.class);
		new Produto("PRD-0009", BigDecimal.valueOf(-559.99));
	}

	@Test
	public void deveriaCriarProduto() {
		new Produto("PRD-0009", BigDecimal.valueOf(559.99));
	}

	@Test
	public void naoDeveriaAlterarPrecoParaNegativo() {
		thrown.expect(IllegalArgumentException.class);
		Produto iPhone6 = new Produto("PRD-0001", BigDecimal.valueOf(2399.99));
		iPhone6.setPreco(BigDecimal.valueOf(-1));
	}

}
