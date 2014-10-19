package br.loja.dominio;

import java.math.BigDecimal;

import org.hamcrest.Factory;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.loja.dominio.databuilders.CriadorDeProduto;
import br.loja.utilidades.macthers.ValorDoFreteMatcher;

public class TestesProduto {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void naoDeveriaAceitarProdutosComPrecoNegativo() {
		thrown.expect(IllegalArgumentException.class);
		new Produto("PRD-0009", BigDecimal.valueOf(-559.99));
	}

	@Test
	public void deveriaCriarProduto() {
		new Produto("PRD-0009", BigDecimal.valueOf(559.99));
	}

	@Test
	public void naoDeveriaAlterarPrecoParaNegativo() {
		thrown.expect(IllegalArgumentException.class);
		Produto iPhone6 = new Produto("PRD-0001", BigDecimal.valueOf(2399.99));
		iPhone6.setPreco(BigDecimal.valueOf(-1));
	}

	@Test
	public void deveriaRetornarValorDoFrete() {
		Produto produto = CriadorDeProduto.umProduto().comPreco(BigDecimal.valueOf(199.00)).criar();
		Assert.assertThat(produto, tenhaValorDoFrete(BigDecimal.valueOf(19.90).setScale(2)));
	}

	@Factory
	public static ValorDoFreteMatcher tenhaValorDoFrete(BigDecimal valorFrete) {
		return new ValorDoFreteMatcher(valorFrete);
	}

}
