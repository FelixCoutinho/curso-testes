package br.loja.dominio;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.loja.dominio.databuilders.CriadorDeCarrinho;
import br.loja.dominio.databuilders.CriadorDePagamento;
import br.loja.dominio.databuilders.CriadorDePedido;
import br.loja.dominio.databuilders.CriadorDeProduto;

public class TestesPagamento {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void deveriaCriarPagamentoComBaseNoPedido() {
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar()).criar();
		new Pagamento(CriadorDePedido.umPedido().comCarrinho(carrinho).criar(), TipoPagamento.DEBITO);
	}

	@Test
	public void deveriaPorPadraoDeixarPagamentoNaoAutorizado() {
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar()).criar();
		Pagamento pagamento = CriadorDePagamento.umPagamento()
				.comPedido(CriadorDePedido.umPedido().comCarrinho(carrinho).criar()).criar();
		assertThat(pagamento.isAutorizado(), equalTo(false));
	}

	@Test
	public void deveriaNaoPermitirCriarPagamentoSemTipo() {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Não é possível criar um pagamento sem definir o Tipo do Pagamento.");
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar()).criar();
		CriadorDePagamento.umPagamento().comPedido(CriadorDePedido.umPedido().comCarrinho(carrinho).criar())
				.comTipoPagamento(null).criar();
	}
	
}
