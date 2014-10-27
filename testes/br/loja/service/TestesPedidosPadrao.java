package br.loja.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.loja.dominio.Pedido;
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
		this.pedidoServicePadrao.efetuarPedido(any(Pedido.class));

		verify(this.pagamentoService, times(1)).pagar(any(Pedido.class));
		verify(this.entregaService, times(1)).solicitarEntrega(any(Pedido.class));
	}

	@Test
	public void deveriaNaoEfetuarPedidoPorPagamentoNaoAutorizado() throws PagamentoNaoAutorizadoException {
		doThrow(PagamentoNaoAutorizadoException.class).when(this.pagamentoService).pagar(any(Pedido.class));

		thrown.expect(PagamentoNaoAutorizadoException.class);

		this.pedidoServicePadrao.efetuarPedido(any(Pedido.class));
	}

}
