package br.loja.service.terceiros;

import java.math.BigDecimal;

public class GatewayPagamentoWebService implements GatewayPagamentoService {

	@Override
	public Boolean processarPagamento(BigDecimal valor, Integer tipoPagamento, String cpf) {
		return null;
	}

}
