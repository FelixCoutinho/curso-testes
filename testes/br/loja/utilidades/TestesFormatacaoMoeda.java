package br.loja.utilidades;

import java.math.BigDecimal;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import br.loja.dominio.Produto;
import br.loja.utilidades.rules.LocaleRule;

public class TestesFormatacaoMoeda {

	@Rule  
    public LocaleRule locale = new LocaleRule(new Locale("pt", "BR"));  

	@Test
	public void test() {
		Assert.assertEquals("A formatação do preço não está correta.",
				"R$ 99,00", new Produto("PRD-001", BigDecimal.valueOf(99.00)).getPrecoFormatado());
	}

}
