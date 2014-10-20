package br.loja.service;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.loja.dominio.Pagamento;
import br.loja.dominio.Pedido;
import br.loja.dominio.databuilders.CriadorDeCarrinho;
import br.loja.dominio.databuilders.CriadorDePagamento;
import br.loja.dominio.databuilders.CriadorDePedido;
import br.loja.dominio.databuilders.CriadorDeProduto;
import br.loja.exceptions.PagamentoNaoAutorizadoException;

public class TestesPedidosPadrao {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Mock
	private PagamentoService pagamentoService;

	@Mock
	private EntregaService entregaService;

	private PedidoService pedidoServicePadrao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.pedidoServicePadrao = new PedidoServicePadrao(this.pagamentoService, this.entregaService);
	}

	@Test
	public void deveriaEfetuarUmPedido() throws PagamentoNaoAutorizadoException {
		Pedido pedido = CriadorDePedido.umPedido()
				.comCarrinho(CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar()).criar())
				.criar();
		Pedido pedidoComUidCorreios = CriadorDePedido.umPedido()
				.comCarrinho(CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar()).criar())
				.criar();
		Pagamento pagamento = CriadorDePagamento.umPagamento().autorizado().criar();
		
		Mockito.when(this.pagamentoService.pagar(pedido)).thenReturn(pagamento);
		Mockito.when(this.entregaService.solicitarEntrega(pedido)).thenReturn(pedidoComUidCorreios);
		
		Assert.assertThat(this.pedidoServicePadrao.efetuarPedido(pedido).getUidCorreios(), Matchers.notNullValue());
	}

	@Test
	public void deveriaNaoEfetuarPedidoPorPagamentoNaoAutorizado() throws PagamentoNaoAutorizadoException {
		Pedido pedido = CriadorDePedido.umPedido()
				.comCarrinho(CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar()).criar())
				.criar();
		Pedido pedidoComUidCorreios = CriadorDePedido.umPedido()
				.comCarrinho(CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar()).criar())
				.criar();
		Pagamento pagamento = CriadorDePagamento.umPagamento().criar();

		Mockito.when(this.pagamentoService.pagar(pedido)).thenReturn(pagamento);
		Mockito.when(this.entregaService.solicitarEntrega(pedido)).thenReturn(pedidoComUidCorreios);

		thrown.expect(PagamentoNaoAutorizadoException.class);
		thrown.expectMessage("Desculpe, seu pagamento não foi autorizado.");

		this.pedidoServicePadrao.efetuarPedido(pedido);
	}

}
