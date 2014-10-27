package br.loja.dominio.databuilders;

import br.loja.dominio.Carrinho;
import br.loja.dominio.Pagamento;
import br.loja.dominio.Pedido;
import br.loja.dominio.TipoPagamento;

public class CriadorDePedido {

	private String uidCorreios = "RS01902911BR";

	private Carrinho carrinho = new Carrinho();

	private TipoPagamento tipoPagamento;

	private CriadorDePedido() {
	}

	public static CriadorDePedido umPedido() {
		return new CriadorDePedido();
	}

	public Pedido criar() {
		Pedido pedido = new Pedido(this.carrinho);
		pedido.setUidCorreios(uidCorreios);
		if(tipoPagamento != null){
			pedido.setPagamento(new Pagamento(pedido, this.tipoPagamento));
		}
		return pedido;
	}

	public CriadorDePedido comUidCorreios(String uidCorreios) {
		this.uidCorreios = uidCorreios;
		return this;
	}

	public CriadorDePedido comCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
		return this;
	}

	public CriadorDePedido comPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
		return this;
	}

}
