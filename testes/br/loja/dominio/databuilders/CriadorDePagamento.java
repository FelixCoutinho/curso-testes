package br.loja.dominio.databuilders;

import br.loja.dominio.Pagamento;
import br.loja.dominio.Pedido;
import br.loja.dominio.TipoPagamento;

public class CriadorDePagamento {

	private Pedido pedido = CriadorDePedido.umPedido()
			.comCarrinho(CriadorDeCarrinho.umCarrinho().comProduto(CriadorDeProduto.umProduto().criar()).criar())
			.criar();
	
	private TipoPagamento tipoPagamento = TipoPagamento.DEBITO;
	
	private CriadorDePagamento() {
	}

	public static CriadorDePagamento umPagamento() {
		return new CriadorDePagamento();
	}

	public Pagamento criar() {
		Pagamento pagamento = new Pagamento(this.pedido, this.tipoPagamento);
		return pagamento;
	}

	public CriadorDePagamento comPedido(Pedido pedido) {
		this.pedido = pedido;
		return this;
	}

	public CriadorDePagamento comTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
		return this;
	}

}
