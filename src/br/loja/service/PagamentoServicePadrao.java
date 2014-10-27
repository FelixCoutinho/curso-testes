package br.loja.service;

import java.math.BigDecimal;

import br.loja.dominio.ItemPedido;
import br.loja.dominio.Pedido;
import br.loja.repositorio.RepositorioPagamentos;
import br.loja.service.terceiros.GatewayPagamentoService;

public class PagamentoServicePadrao implements PagamentoService {

	private GatewayPagamentoService gatewayPagamentoService;
	private RepositorioPagamentos repositorioPagamentos;

	public PagamentoServicePadrao(GatewayPagamentoService gatewayPagamentoService,
			RepositorioPagamentos repositorioPagamentos) {
		this.gatewayPagamentoService = gatewayPagamentoService;
		this.repositorioPagamentos = repositorioPagamentos;
	}

	@Override
	public void pagar(Pedido pedido) {
		BigDecimal valorTotal = BigDecimal.valueOf(0.0).setScale(2);
		for (ItemPedido itemPedido : pedido.getItens()) {
			valorTotal = valorTotal.add((itemPedido.getProduto().getPreco()
					.multiply(BigDecimal.valueOf(itemPedido.getQuantidade()).setScale(2)).add(itemPedido.getProduto()
					.getValorFrete())));
		}
		if (this.gatewayPagamentoService.processarPagamento(valorTotal, null, null)) {
			pedido.getPagamento().setAutorizado(true);
		}
		this.repositorioPagamentos.salvar(pedido.getPagamento());
	}
}
