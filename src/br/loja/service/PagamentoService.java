package br.loja.service;

import br.loja.dominio.Pedido;
import br.loja.exceptions.PagamentoNaoAutorizadoException;

public interface PagamentoService {
	
	void pagar(Pedido pedido) throws PagamentoNaoAutorizadoException;

}
