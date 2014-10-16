package br.loja.testes;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.loja.dominio.Carrinho;
import br.loja.dominio.Item;
import br.loja.dominio.Produto;
import br.loja.testes.builders.CriadorDeCarrinho;
import br.loja.testes.builders.CriadorDeProduto;

public class CarrinhoTest {

	@Test
	public void deveAdicionarItemAoCarrinho() {
		Produto produto = CriadorDeProduto.umProduto().comSKU("PRD-0001").comPreco(BigDecimal.valueOf(2399.99)).criar();
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().criar();
		carrinho.adicionar(produto);
		assertThat(new Item(produto), isIn(carrinho.getItens()));
	}

	@Test
	public void deveTotalizarCarrinho() {
		Carrinho carrinho1 = CriadorDeCarrinho.umCarrinho().criar();

		carrinho1
				.adicionar(
						CriadorDeProduto.umProduto().comSKU("PRD-0001").comPreco(BigDecimal.valueOf(2399.99)).criar())
				.adicionar(
						CriadorDeProduto.umProduto().comSKU("PRD-0009").comPreco(BigDecimal.valueOf(7999.99)).criar())
				.adicionar(CriadorDeProduto.umProduto().comSKU("PRD-0008").comPreco(BigDecimal.valueOf(599.99)).criar());

		Carrinho carrinho2 = CriadorDeCarrinho.umCarrinho().criar();

		assertThat(carrinho1.getTotal(), equalTo(10999.97));
		assertThat(carrinho2.getTotal(), equalTo(0.0));
	}

	@Test
	public void deveTotalizarCarrinhoComApenasUmItem() {
		Produto macMini = new Produto("PRD-0009", BigDecimal.valueOf(599.99));

		Carrinho carrinho = new Carrinho();

		carrinho.adicionar(macMini);

		double totalEsperadoCarrinho = 599.99;
		double totalCarrinho = carrinho.getTotal();

		assertEquals(totalEsperadoCarrinho, totalCarrinho, 0.00001);
	}

	@Test
	public void deveCalcularValorDoFrete() {
		Produto macMini = new Produto("PRD-0009", BigDecimal.valueOf(599.99));

		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().comCep("60320-270").criar();
		carrinho.adicionar(macMini);

		assertEquals(59.99, carrinho.getValorFrete(), 0.01);
	}

	@Test
	public void deveCalcularValorDoFreteParaMultiplosProdutos() {
		Produto iPhone6 = new Produto("PRD-0001", BigDecimal.valueOf(2399.99));
		Produto macBookPro = new Produto("PRD-0009", BigDecimal.valueOf(7999.99));
		Produto macMini = new Produto("PRD-0004", BigDecimal.valueOf(599.99));

		Carrinho carrinho = new Carrinho();
		carrinho.setCep("60320-270");
		carrinho.adicionar(iPhone6);
		carrinho.adicionar(macBookPro);
		carrinho.adicionar(macMini);

		assertEquals(1099.99, carrinho.getValorFrete(), 0.01);
	}

	@Test
	public void deveIncluirValorDoFreteNoTotal() {
		Produto iPhone6 = new Produto("PRD-0001", BigDecimal.valueOf(2399.99));
		Produto macBookPro = new Produto("PRD-0009", BigDecimal.valueOf(7999.99));
		Produto macMini = new Produto("PRD-0008", BigDecimal.valueOf(599.99));

		Carrinho carrinho = new Carrinho();
		carrinho.setCep("60320-270");
		carrinho.adicionar(iPhone6);
		carrinho.adicionar(macBookPro);
		carrinho.adicionar(macMini);

		assertEquals(12099.96, carrinho.getTotal(), 0.01);
	}

	@Test
	public void naoDevemHaverProdutosRepetidos() {
		Carrinho carrinho = new Carrinho();
		carrinho.adicionar(new Produto("PRD-0001", BigDecimal.valueOf(2399.99)));
		carrinho.adicionar(new Produto("PRD-0001", BigDecimal.valueOf(2399.99)));
		carrinho.adicionar(new Produto("PRD-0001", BigDecimal.valueOf(2399.99)));
		assertEquals(1, carrinho.getItens().size());
	}

	@Test
	public void deveIncrementarQuantidadeEmProdutoRepetidos() {
		Carrinho carrinho = new Carrinho();
		carrinho.adicionar(new Produto("PRD-0001", BigDecimal.valueOf(2399.99)));
		carrinho.adicionar(new Produto("PRD-0001", BigDecimal.valueOf(2399.99)));
		carrinho.adicionar(new Produto("PRD-0001", BigDecimal.valueOf(2399.99)));
		assertEquals(new Integer(3), carrinho.getItens().get(0).getQuantidade());
	}

	@Test(expected = RuntimeException.class)
	public void deveInformarQueCarrinhoEstaVazio() {
		Carrinho carrinho = new Carrinho();
		carrinho.getItens();
	}

	@Test
	public void deveriaAdicionarProdutoNoCarrinho() {
		Produto produto = CriadorDeProduto.umProduto().comSKU("PRD-0001").comPreco(BigDecimal.valueOf(2399.99)).criar();
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().comProduto(produto).criar();
		assertThat(carrinho.getItens(), hasItems(new Item(produto)));
	}

	@Test
	public void deveEstarOrdenadoPorPrecoDoProduto() {
		Carrinho carrinho = new Carrinho();
		carrinho.adicionar(new Produto("PRD-0001", BigDecimal.valueOf(2399.99)));
		carrinho.adicionar(new Produto("PRD-0002", BigDecimal.valueOf(399.99)));
		carrinho.adicionar(new Produto("PRD-0003", BigDecimal.valueOf(8399.99)));
		assertThat(
				carrinho.getItens(),
				contains(new Item(new Produto("PRD-0002", BigDecimal.valueOf(399.99))), new Item(new Produto(
						"PRD-0001", BigDecimal.valueOf(2399.99))),
						new Item(new Produto("PRD-0003", BigDecimal.valueOf(8399.99)))));
	}

}
