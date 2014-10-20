package br.loja.service;

import br.loja.dominio.Pedido;
import br.loja.exceptions.PagamentoNaoAutorizadoException;

public interface PedidoService {

	Pedido efetuarPedido(Pedido pedido) throws PagamentoNaoAutorizadoException;

	Pedido consultarPedido(Pedido pedido);

}
