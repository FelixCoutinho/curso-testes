package br.loja.dominio;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.loja.dominio.databuilders.CriadorDeCarrinho;
import br.loja.dominio.databuilders.CriadorDePedido;
import br.loja.dominio.databuilders.CriadorDeProduto;

public class TestesPedido {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void deveriaCriarPedidoComBaseNoCarrinho() {
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar()).criar();
		Pedido pedido = CriadorDePedido.umPedido().comCarrinho(carrinho).criar();
		assertThat(pedido, notNullValue());
	}

	@Test
	public void deveriaCriarItensDoPedido() {
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar()).criar();
		Pedido pedido = CriadorDePedido.umPedido().comCarrinho(carrinho).criar();
		assertThat(pedido.getItens(), notNullValue());
	}

	@Test
	public void deveriaCriarUmItemDoPedidoParaCadaItemDoCarrinho() {
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar()).criar();
		Pedido pedido = CriadorDePedido.umPedido().comCarrinho(carrinho).criar();
		assertThat(pedido.getItens().size(), equalTo(1));
	}

	@Test
	public void deveriaCriarUmItemDoPedidoComQuantidadeCorreta() {
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar()).criar();
		carrinho.adicionarProduto(CriadorDeProduto.umProduto().criar());
		Pedido pedido = CriadorDePedido.umPedido().comCarrinho(carrinho).criar();
		assertThat(pedido.getItens().get(0).getQuantidade(), equalTo(2));
	}

	@Test
	public void deveriaCriarUmItemDoPedidoComProdutoCorreto() {
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar()).criar();
		carrinho.adicionarProduto(CriadorDeProduto.umProduto().criar());
		Pedido pedido = CriadorDePedido.umPedido().comCarrinho(carrinho).criar();
		assertThat(pedido.getItens().get(0).getProduto(), equalTo(CriadorDeProduto.umProduto().criar()));
	}

	@Test
	public void deveriaNaoPermitirCriarPedidoComCarrinhoVazio() {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Não é possível criar um pedido sem ter selecionado itens ao carrinho.");
		CriadorDePedido.umPedido().criar();
	}

}
