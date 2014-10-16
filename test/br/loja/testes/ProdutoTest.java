package br.loja.testes;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.loja.dominio.Produto;
import br.loja.utilidades.FormatadorDeMoeda;

public class ProdutoTest {

	private static final Locale localeOriginal = Locale.getDefault();

	@Before
	public void setup() {
		Locale.setDefault(new Locale("en", "US"));
	}

	@After
	public void cleanUp() {
		Locale.setDefault(localeOriginal);
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveAceitarProdutosComValoresNegativos() {
		new Produto("PRD-0001", BigDecimal.valueOf(-0.99));
	}

	@Test
	public void deveriaFormatarPrecoComPadraoBrasileiro() {
		assertEquals("A formatação do preço não corresponde com o padrão pt-BR.", "R$ 19,99",
				FormatadorDeMoeda.formatar(new Produto("PRD-0001", BigDecimal.valueOf(19.99)).getPreco()));
	}
}
