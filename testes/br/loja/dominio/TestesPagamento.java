package br.loja.dominio;

import org.junit.Test;

import br.loja.dominio.databuilders.CriadorDeCarrinho;
import br.loja.dominio.databuilders.CriadorDePedido;
import br.loja.dominio.databuilders.CriadorDeProduto;

public class TestesPagamento {

	@Test
	public void deveriaCriarPagamentoComBaseNoPedido() {
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar()).criar();
		new Pagamento(CriadorDePedido.umPedido().comCarrinho(carrinho).criar());
	}
}
