package br.loja.utilidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestesListaOrdenada {

	@Test
	public void trazListaOrdenadaComTodosOsElementos() {
	  List<Integer> lista = new ArrayList<Integer>();
	  lista.add(5);
	  lista.add(3);
	  lista.add(2);
	  lista.add(7);
	 
	  Collections.sort(lista);
	 
	  Assert.assertEquals(4, lista.size());
	  Assert.assertEquals(new Integer(2), lista.get(0));
	  Assert.assertEquals(new Integer(3), lista.get(1));
	  Assert.assertEquals(new Integer(5), lista.get(2));
	  Assert.assertEquals(new Integer(7), lista.get(3));
	}
}
