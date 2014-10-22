package br.loja.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.loja.dominio.ItemPedido;
import br.loja.dominio.Pagamento;
import br.loja.dominio.Pedido;
import br.loja.dominio.TipoPagamento;
import br.loja.dominio.databuilders.CriadorDeCarrinho;
import br.loja.dominio.databuilders.CriadorDePedido;
import br.loja.dominio.databuilders.CriadorDeProduto;
import br.loja.exceptions.PagamentoNaoAutorizadoException;
import br.loja.repositorio.RepositorioPagamentos;
import br.loja.service.terceiros.GatewayPagamentoService;

public class TestesPagamentoPadrao {

	private PagamentoService pagamentoService;

	@Mock
	private GatewayPagamentoService gatewayPagamentoService;

	@Mock
	private RepositorioPagamentos repositorioPagamentos;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.pagamentoService = new PagamentoServicePadrao(this.gatewayPagamentoService, this.repositorioPagamentos);
	}

	@Test
	public void deveriaAlterarPedidoParaAutorizado() throws PagamentoNaoAutorizadoException {
		Pedido pedido = spy(CriadorDePedido.umPedido()
				.comCarrinho(CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar()).criar())
				.comPagamento(TipoPagamento.DEBITO).criar());

		when(pedido.getItens()).thenReturn(Collections.<ItemPedido> emptyList());
		when(
				this.gatewayPagamentoService.processarPagamento(any(BigDecimal.class), any(Integer.class),
						any(String.class))).thenReturn(true);

		this.pagamentoService.pagar(pedido);

		ArgumentCaptor<Pagamento> pagamento = ArgumentCaptor.forClass(Pagamento.class);

		verify(this.repositorioPagamentos).salvar(pagamento.capture());
		verify(this.gatewayPagamentoService).processarPagamento(any(BigDecimal.class), any(Integer.class),
				any(String.class));

		assertTrue(pagamento.getValue().isAutorizado());
	}
}
