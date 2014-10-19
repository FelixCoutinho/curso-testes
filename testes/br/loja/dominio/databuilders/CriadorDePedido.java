package br.loja.dominio.databuilders;

import br.loja.dominio.Carrinho;
import br.loja.dominio.Pedido;

public class CriadorDePedido {

	private Carrinho carrinho = new Carrinho();

	private CriadorDePedido() {
	}

	public static CriadorDePedido umPedido() {
		return new CriadorDePedido();
	}

	public Pedido criar() {
		Pedido pedido = new Pedido(this.carrinho);
		return pedido;
	}

	public CriadorDePedido comCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
		return this;
	}

}
