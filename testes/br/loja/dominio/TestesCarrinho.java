package br.loja.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.loja.dominio.databuilders.CriadorDeCarrinho;
import br.loja.dominio.databuilders.CriadorDeProduto;

public class TestesCarrinho {

	@Test
	public void deveriaTotalizarCarrinhoComProdutos() {
		Produto iPhone6 = CriadorDeProduto.umProduto().comPreco(2399.99).comSKU("PRD-0001").criar();
		Produto macBookPro = CriadorDeProduto.umProduto().comPreco(7999.99).comSKU("PRD-0009").criar();

		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().comProduto(macBookPro).comProduto(iPhone6).criar();

		Double totalEsperado = iPhone6.getPreco() + macBookPro.getPreco();
		totalEsperado = totalEsperado * 1.10;

		assertEquals("O valor total do carrinho não é o esperado.", totalEsperado, carrinho.getTotal(), 0.001);
	}

	@Test
	public void deveriaTotalizarCarrinhoSemProdutos() {
		Carrinho carrinhoDeComprasCliente2 = new Carrinho();
		assertEquals("O valor total do carrinho sem produtos não é o esperado.", Double.valueOf(0),
				carrinhoDeComprasCliente2.getTotal());
	}

	@Test
	public void deveriaTotalizarApenasSubTotal() {
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho()
				.comProduto(CriadorDeProduto.umProduto().comSKU("PRD-0001").comPreco(10.0).criar())
				.comProduto(CriadorDeProduto.umProduto().comSKU("PRD-0009").comPreco(22.0).criar()).criar();
		assertEquals("O valor do sub total não está correto.", Double.valueOf(32.00), carrinho.getSubTotal());
	}

	@Test
	public void deveriaTotalizarApenasValorTotalDoFrete() {
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho()
				.comProduto(CriadorDeProduto.umProduto().comSKU("PRD-0001").comPreco(10.0).criar())
				.comProduto(CriadorDeProduto.umProduto().comSKU("PRD-0009").comPreco(22.0).criar()).criar();
		assertEquals("O valor total do frete não está correto.", Double.valueOf(3.20), carrinho.getTotalValorFrete());
	}

	@Test
	public void deveriaRetornarValorZeroSemProdutos() {
		Carrinho carrinho = new Carrinho();
		assertEquals("O valor do frete sem produtos não está correto.", Double.valueOf(0), carrinho.getTotal());
	}

	@Test
	public void deveriaRetornarSubTotalZeroSemProdutos() {
		Carrinho carrinho = new Carrinho();
		assertEquals("O valor do frete sem produtos não está correto.", Double.valueOf(0), carrinho.getSubTotal());
	}

	@Test
	public void deveriaRetornarTotalFreteZeroSemProdutos() {
		Carrinho carrinho = new Carrinho();
		assertEquals("O valor do frete sem produtos não está correto.", Double.valueOf(0),
				carrinho.getTotalValorFrete());
	}

	@Test
	public void deveriaExistirApenasUmItemNoCarrinho() {
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar())
				.comProduto(CriadorDeProduto.umProduto().criar()).criar();
		assertEquals("A quantidade itens do carrinho não está correta.", Integer.valueOf(1),
				Integer.valueOf(carrinho.getItens().size()));
	}

	@Test
	public void deveriaTerQuantidadeDeItemIncrementada() {
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar())
				.comProduto(CriadorDeProduto.umProduto().criar()).criar();
		assertEquals("A quantidade itens do carrinho não está correta.", Integer.valueOf(2),
				Integer.valueOf(carrinho.getItens().get(0).getQuantidade()));
	}

	@Test
	public void deveriaTerQuantidadeDeItemIncrementadaAcimaDeDois() {
		Produto produto = CriadorDeProduto.umProduto().criar();
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().comProduto(produto).comProduto(produto).comProduto(produto)
				.criar();
		assertEquals("A quantidade itens do carrinho não está correta.", Integer.valueOf(3),
				Integer.valueOf(carrinho.getItens().get(0).getQuantidade()));
	}

	@Test
	public void deveriaIncluirProdutoDiretamenteNoCarrinho() {
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().criar();
		carrinho.adicionarProduto(CriadorDeProduto.umProduto().criar());
		assertEquals("", Integer.valueOf(1), Integer.valueOf(carrinho.getItens().size()));
	}

	@Test
	public void deveriaIncluirProdutoDiretamenteNoCarrinho2() {
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar()).criar();
		assertEquals("", Integer.valueOf(1), Integer.valueOf(carrinho.getItens().size()));
	}
}
