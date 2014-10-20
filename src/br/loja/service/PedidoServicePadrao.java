package br.loja.service;

import br.loja.dominio.Carrinho;
import br.loja.dominio.Pagamento;
import br.loja.dominio.Pedido;

public class PedidoServicePadrao implements PedidoService {

	private PagamentoService pagamentoService;

	private EntregaService entregaService;

	public PedidoServicePadrao(PagamentoService pagamentoService, EntregaService entregaService) {
		this.pagamentoService = pagamentoService;
		this.entregaService = entregaService;
	}

	@Override
	public Pedido efetuarPedido(Carrinho carrinho) {
		Pedido pedido = new Pedido(carrinho);
		Pagamento pagamento = this.pagamentoService.pagar(pedido);
		if(pagamento.isAutorizado()){
			pedido = this.entregaService.solicitarEntrega(pedido);
		}		
		return pedido;
	}

	@Override
	public Pedido consultarPedido(Pedido pedido) {
		return null;
	}

}
