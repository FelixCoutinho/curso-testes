package br.loja.service.terceiros;

import java.math.BigDecimal;

public interface GatewayPagamentoService {

	Boolean processarPagamento(BigDecimal valor, Integer tipoPagamento, String cpf);
}
