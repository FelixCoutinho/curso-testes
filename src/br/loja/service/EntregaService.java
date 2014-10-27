package br.loja.service;

import br.loja.dominio.Pedido;

public interface EntregaService {

	void solicitarEntrega(Pedido pedido);

	Pedido consultarEntrega(Pedido pedido);

}
