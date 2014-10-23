package br.loja.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_pedido")
	private Integer id;

	@Column(name = "quantidade")
	private Integer quantidade;

	@OneToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;

	@OneToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	public ItemPedido(Item itemCarrinho) {
		this.quantidade = itemCarrinho.getQuantidade();
		this.produto = itemCarrinho.getProduto();
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public Produto getProduto() {
		return this.produto;
	}

}
