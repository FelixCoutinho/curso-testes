package br.loja.utilidades;

import java.util.Locale;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.loja.dominio.Produto;

public class TestesFormatacaoMoeda {

	private static final Locale localeOriginal = Locale.getDefault();

	@Before
	public void setUp() {
		Locale.setDefault(new Locale("en", "US"));
	}

	@After
	public void down() {
		Locale.setDefault(localeOriginal);
	}

	@Test
	public void test() {
		Assert.assertEquals("A formatação do preço não está correta.",
				"R$ 99,00", new Produto("PRD-001", 99.00).getPrecoFormatado());
	}

}
