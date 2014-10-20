package br.loja.service;

import br.loja.dominio.Pagamento;
import br.loja.dominio.Pedido;

public interface PagamentoService {
	
	Pagamento pagar(Pedido pedido);

}
