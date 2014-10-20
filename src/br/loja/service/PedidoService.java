package br.loja.service;

import br.loja.dominio.Carrinho;
import br.loja.dominio.Pedido;

public interface PedidoService {

	Pedido efetuarPedido(Carrinho carrinho);

	Pedido consultarPedido(Pedido pedido);

}
