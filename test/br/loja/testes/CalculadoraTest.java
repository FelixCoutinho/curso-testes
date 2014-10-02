package br.loja.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.loja.utilidades.Calculadora;

public class CalculadoraTest {

	@Test
	public void deveSomarUmMaisUm() {
		assertEquals(Integer.valueOf(2), new Calculadora().soma(1, 1));
	}

	@Test
	public void deveSomarUmMaisDois() {
		assertEquals(Integer.valueOf(3), new Calculadora().soma(1, 2));
	}

	@Test
	public void deveSomarDoisMaisDois() {
		assertEquals(Integer.valueOf(4), new Calculadora().soma(2, 2));
	}

}
