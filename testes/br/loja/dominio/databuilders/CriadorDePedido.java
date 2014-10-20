package br.loja.dominio.databuilders;

import br.loja.dominio.Carrinho;
import br.loja.dominio.Pedido;

public class CriadorDePedido {

	private String uidCorreios = "RS01902911BR";

	private Carrinho carrinho = new Carrinho();

	private CriadorDePedido() {
	}

	public static CriadorDePedido umPedido() {
		return new CriadorDePedido();
	}

	public Pedido criar() {
		Pedido pedido = new Pedido(this.carrinho);
		pedido.setUidCorreios(uidCorreios);
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

}
