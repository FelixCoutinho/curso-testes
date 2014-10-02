package br.loja.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.loja.dominio.Carrinho;
import br.loja.dominio.Produto;
import br.loja.testes.builders.CriadorDeCarrinho;
import br.loja.testes.builders.CriadorDeProduto;

public class CarrinhoTest {

	@Test
	public void deveTotalizarCarrinho() {
		// 1 - Cenário
		Carrinho carrinho1 = CriadorDeCarrinho.umCarrinho().criar();

		carrinho1.adicionar(CriadorDeProduto.umProduto().comSKU("PRD-0001").comPreco(2399.99).criar())
				.adicionar(CriadorDeProduto.umProduto().comSKU("PRD-0009").comPreco(7999.99).criar())
				.adicionar(CriadorDeProduto.umProduto().comSKU("PRD-0008").comPreco(599.99).criar());

		Carrinho carrinho2 = CriadorDeCarrinho.umCarrinho().criar();

		// 2 - Ação
		double totalEsperadoCarrinho1 = 10999.97;
		double totalEsperadoCarrinho2 = 0.0;
		double totalCarrinho1 = carrinho1.getTotal();
		double totalCarrinho2 = carrinho2.getTotal();

		// 3 - Validação
		assertEquals(totalEsperadoCarrinho1, totalCarrinho1, 0.01);
		assertEquals(totalEsperadoCarrinho2, totalCarrinho2, 0.01);
	}

	@Test
	public void deveTotalizarCarrinhoComApenasUmItem() {
		Produto macMini = new Produto("PRD-0009", 599.99);

		Carrinho carrinho = new Carrinho();

		carrinho.adicionar(macMini);

		double totalEsperadoCarrinho = 599.99;
		double totalCarrinho = carrinho.getTotal();

		assertEquals(totalEsperadoCarrinho, totalCarrinho, 0.00001);
	}

	@Test
	public void deveCalcularValorDoFrete() {
		Produto macMini = new Produto("PRD-0009", 599.99);

		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().comCep("60320-270").criar();
		carrinho.adicionar(macMini);

		assertEquals(59.99, carrinho.getValorFrete(), 0.01);
	}

	@Test
	public void deveCalcularValorDoFreteParaMultiplosProdutos() {
		Produto iPhone6 = new Produto("PRD-0001", 2399.99);
		Produto macBookPro = new Produto("PRD-0009", 7999.99);
		Produto macMini = new Produto("PRD-0004", 599.99);

		Carrinho carrinho = new Carrinho();
		carrinho.setCep("60320-270");
		carrinho.adicionar(iPhone6);
		carrinho.adicionar(macBookPro);
		carrinho.adicionar(macMini);

		assertEquals(1099.99, carrinho.getValorFrete(), 0.01);
	}

	@Test
	public void deveIncluirValorDoFreteNoTotal() {
		Produto iPhone6 = new Produto("PRD-0001", 2399.99);
		Produto macBookPro = new Produto("PRD-0009", 7999.99);
		Produto macMini = new Produto("PRD-0008", 599.99);

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
		carrinho.adicionar(new Produto("PRD-0001", 2399.99));
		carrinho.adicionar(new Produto("PRD-0001", 2399.99));
		carrinho.adicionar(new Produto("PRD-0001", 2399.99));
		assertEquals(1, carrinho.getItens().size());
	}

	@Test
	public void deveIncrementarQuantidadeEmProdutoRepetidos() {
		Carrinho carrinho = new Carrinho();
		carrinho.adicionar(new Produto("PRD-0001", 2399.99));
		carrinho.adicionar(new Produto("PRD-0001", 2399.99));
		carrinho.adicionar(new Produto("PRD-0001", 2399.99));
		assertEquals(new Integer(3), carrinho.getItens().get(0).getQuantidade());
	}

	@Test(expected = RuntimeException.class)
	public void deveInformarQueCarrinhoEstaVazio() {
		Carrinho carrinho = new Carrinho();
		carrinho.getItens();
	}

}
