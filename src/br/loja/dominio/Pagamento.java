package br.loja.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pagamentos")
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PAGAMENTO")
	private Integer id;

	@Column(name = "AUTORIZADO")
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
