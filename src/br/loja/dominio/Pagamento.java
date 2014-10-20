package br.loja.dominio;

public class Pagamento {

	private Boolean autorizado;

	public Pagamento(Pedido pedido, TipoPagamento tipoPagamento) {
		if (tipoPagamento == null) {
			throw new RuntimeException("Não é possível criar um pagamento sem definir o Tipo do Pagamento.");
		}
		this.autorizado = false;
	}

	public Boolean isAutorizado() {
		return this.autorizado;
	}

	public void setAutorizado(Boolean autorizado) {
		this.autorizado = autorizado;
	}

}
