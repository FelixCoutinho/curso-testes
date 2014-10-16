package br.loja.testes;

import static org.junit.Assume.assumeTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import br.loja.utilidades.FormatadorDeData;

public class AssumeLocalePtBr {

	@Before
	public void setUp() throws UnknownHostException {
		assumeTrue(Locale.getDefault().toString().equals("pt_BR"));
	}

	@Test
	public void deveriaFormatarCorretamenteDataParaPortuguês() {
		FormatadorDeData formatadorDeData = new FormatadorDeData();
		assertThat(formatadorDeData.formata(new Date()), equalTo("16 de Outubro"));
	}
}
