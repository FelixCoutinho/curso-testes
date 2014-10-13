package br.loja.service;

import br.loja.dominio.Carrinho;

public interface ProcessadorDePagamento {

	void processarPagamento(Carrinho carrinho);
}
