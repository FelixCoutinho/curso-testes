package br.loja.utilidades;

import static org.hamcrest.Matchers.contains;

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
	 
	  Assert.assertThat(lista, contains(2, 3, 5, 7));
	}
}
