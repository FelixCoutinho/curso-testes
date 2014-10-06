package br.loja.testes;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.loja.utilidades.Calculadora;

public class CalculadoraTest {

	@Test
	public void deveSomarUmMaisUm() {
		assertThat(new Calculadora().soma(1, 1), equalTo(Integer.valueOf(2)));
	}

	@Test
	public void deveSomarUmMaisDois() {
		assertEquals(Integer.valueOf(3), new Calculadora().soma(1, 2));
	}

	@Test
	public void deveSomarDoisMaisDois() {
		assertEquals(Integer.valueOf(4), new Calculadora().soma(2, 2));
	}

	@Test(expected = RuntimeException.class)
	public void naoDeveAceitarValoresNulos() {
		new Calculadora().soma(null, null);
	}

}
