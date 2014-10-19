package br.loja.utilidades.macthers;

import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class PrimeiroElementoMatcher extends TypeSafeMatcher<List<Integer>> {
	public void describeTo(Description desc) {
		desc.appendText("Uma lista começando com 2");
	}

	protected boolean matchesSafely(List<Integer> listaRecebida) {
		if (listaRecebida.size() > 0) {
			return listaRecebida.get(0) == 2;
		}
		return false;
	}
}
