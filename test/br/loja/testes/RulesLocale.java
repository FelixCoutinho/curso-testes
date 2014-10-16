package br.loja.testes;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import br.loja.utilidades.FormatadorDeData;

public class RulesLocale {

	@Test
	public void deveFormatarDataParaRelatorio() {
		FormatadorDeData formatador = new FormatadorDeData();
		String dataFormatada = formatador.formata(new Date(1387771261000l));
		assertEquals("23 de Dezembro", dataFormatada);
	}

}
