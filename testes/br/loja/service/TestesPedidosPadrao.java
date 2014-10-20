package br.loja.service;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
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
		
		when(this.pagamentoService.pagar(pedido)).thenReturn(pagamento);
		when(this.entregaService.solicitarEntrega(pedido)).thenReturn(pedidoComUidCorreios);
		
		assertThat(this.pedidoServicePadrao.efetuarPedido(pedido).getUidCorreios(), notNullValue());
		
		verify(this.pagamentoService).pagar(pedido);
		verify(this.entregaService).solicitarEntrega(pedido);
	}

	@Test
	public void deveriaNaoEfetuarPedidoPorPagamentoNaoAutorizado() throws PagamentoNaoAutorizadoException {
		Pedido pedido = CriadorDePedido.umPedido()
				.comCarrinho(CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar()).criar())
				.criar();
		Pagamento pagamento = CriadorDePagamento.umPagamento().criar();

		when(this.pagamentoService.pagar(any(Pedido.class))).thenReturn(pagamento);
		when(this.entregaService.solicitarEntrega(any(Pedido.class))).thenReturn(any(Pedido.class));

		thrown.expect(PagamentoNaoAutorizadoException.class);
		thrown.expectMessage("Desculpe, seu pagamento não foi autorizado.");

		this.pedidoServicePadrao.efetuarPedido(pedido);
		
		verify(this.pagamentoService).pagar(pedido);
		verify(this.entregaService).solicitarEntrega(pedido);
	}

}
