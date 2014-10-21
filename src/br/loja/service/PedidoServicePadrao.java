package br.loja.service;

import br.loja.dominio.Pagamento;
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
	public Pedido efetuarPedido(Pedido pedido) throws PagamentoNaoAutorizadoException {
		Pagamento pagamento = this.pagamentoService.pagar(pedido);
		if (pagamento.isAutorizado()) {
			pedido.setPagamento(pagamento);
			pedido = this.entregaService.solicitarEntrega(pedido);
		} else {
			throw new PagamentoNaoAutorizadoException("Desculpe, seu pagamento não foi autorizado.");
		}
		return pedido;
	}

	@Override
	public Pedido consultarPedido(Pedido pedido) {
		return null;
	}

}
