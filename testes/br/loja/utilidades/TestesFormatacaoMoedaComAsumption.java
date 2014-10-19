package br.loja.utilidades;

import java.math.BigDecimal;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import br.loja.dominio.Produto;

public class TestesFormatacaoMoedaComAsumption {

	@Before
	public void setUp() {
		Assume.assumeTrue("Só deveria executar para ambientes com pt-BR.", new Locale("pt", "BR").equals(Locale.getDefault()));
	}

	@Test
	public void test() {
		Assert.assertEquals("A formatação do preço não está correta.", "R$ 99,00",
				new Produto("PRD-001", BigDecimal.valueOf(99.00)).getPrecoFormatado());
	}

}
