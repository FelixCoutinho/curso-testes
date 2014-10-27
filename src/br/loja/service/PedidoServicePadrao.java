package br.loja.service;

import br.loja.dominio.Pedido;
import br.loja.exceptions.PagamentoNaoAutorizadoException;

public class PedidoServicePadrao implements PedidoService {

	private PagamentoService pagamentoService;

	private EntregaService entregaService;

	public PedidoServicePadrao(PagamentoService pagamentoService, EntregaService entregaService) {
		this.pagamentoService = pagamentoService;
		this.entregaService = entregaService;
	}

	@Override
	public void efetuarPedido(Pedido pedido) throws PagamentoNaoAutorizadoException {
		this.pagamentoService.pagar(pedido);
		this.entregaService.solicitarEntrega(pedido);
	}

	@Override
	public Pedido consultarPedido(Pedido pedido) {
		return null;
	}

}
