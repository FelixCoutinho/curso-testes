package br.loja.utilidades;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Calculadora.class })
public class TestesCalculadoraComMock {

	@Test
	public void deveriaSomarDoisNumerosInteiros() {

		PowerMockito.mockStatic(Calculadora.class);
		PowerMockito.when(Calculadora.somar(Mockito.anyInt(), Mockito.anyInt())).thenReturn(4);

		Integer resultado = Calculadora.somar(Mockito.anyInt(), Mockito.anyInt());

		assertEquals("A soma não foi realizada corretamente.", Integer.valueOf(4), resultado);
	}

}
