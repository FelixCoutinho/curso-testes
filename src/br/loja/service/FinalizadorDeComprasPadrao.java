package br.loja.service;

import br.loja.dominio.Carrinho;

public class FinalizadorDeComprasPadrao implements FinalizadorDeCompras {

	private TransportadoraService transportadora;
	private ProcessadorDePagamento processadorDePagamento;

	public FinalizadorDeComprasPadrao(TransportadoraService transportadora, ProcessadorDePagamento processadorDePagamento) {
		this.transportadora = transportadora;
		this.processadorDePagamento = processadorDePagamento;
	}

	@Override
	public void finalizarCompra(Carrinho carrinho) {
		this.processadorDePagamento.processarPagamento(carrinho);
		this.transportadora.enviarEncomenda(carrinho.getItens());
	}

}
