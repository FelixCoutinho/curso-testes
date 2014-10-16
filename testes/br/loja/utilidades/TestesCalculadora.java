package br.loja.utilidades;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestesCalculadora {

	@Test
	public void deveriaSomarDoisNumerosInteiros() {
		assertEquals("A soma n�o foi realizada corretamente.",
				Integer.valueOf(2), Calculadora.somar(1, 1));
	}
	
	@Test
	public void deveriaSomarUmComDois(){
		assertEquals("A soma n�o foi realizada corretamente.",
				Integer.valueOf(3), Calculadora.somar(1, 2));
	}
	
	@Test
	public void deveriaSomarTresComDez(){
		assertEquals("A soma n�o foi realizada corretamente.",
				Integer.valueOf(13), Calculadora.somar(3, 10));
	}

}
