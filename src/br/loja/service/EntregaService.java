package br.loja.service;

import br.loja.dominio.Pedido;

public interface EntregaService {

	Pedido solicitarEntrega(Pedido pedido);

	Pedido consultarEntrega(Pedido pedido);

}
