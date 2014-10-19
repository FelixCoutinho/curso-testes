package br.loja.utilidades.macthers;

import java.math.BigDecimal;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import br.loja.dominio.Produto;

public class ValorDoFreteMatcher extends TypeSafeMatcher<Produto> {

	private BigDecimal valorFrete;

	public ValorDoFreteMatcher(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("Valor do frete: " + valorFrete);
	}

	@Override
	protected boolean matchesSafely(Produto produto) {
		return produto.getValorFrete().equals(valorFrete);
	}

	@Override
	protected void describeMismatchSafely(final Produto produto, final Description mismatchDescription) {
		mismatchDescription.appendText(" was ").appendValue(produto.getValorFrete());
	}
}
