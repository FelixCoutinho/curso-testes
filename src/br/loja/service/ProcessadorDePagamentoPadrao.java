package br.loja.service;

import br.loja.dominio.Carrinho;

public class ProcessadorDePagamentoPadrao implements ProcessadorDePagamento {

	@Override
	public void processarPagamento(Carrinho carrinho) {
		if (!carrinho.isVazio()) {
			
		}
	}

}
