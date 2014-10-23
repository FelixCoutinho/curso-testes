package br.loja.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Integer id;

	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itens;

	@OneToOne
	@JoinColumn(name = "id_pagamento")
	private Pagamento pagamento;

	@Column(name = "uid_correios")
	private String uidCorreios;

	protected Pedido() {
	}

	public Pedido(Carrinho carrinho) {
		if (carrinho.getItens().size() == 0) {
			throw new RuntimeException("Não é possível criar um pedido sem ter selecionado itens ao carrinho.");
		}
		this.itens = new ArrayList<ItemPedido>();
		for (Item itemCarrinho : carrinho.getItens()) {
			this.itens.add(new ItemPedido(itemCarrinho));
		}
	}

	public List<ItemPedido> getItens() {
		return this.itens;
	}

	public String getUidCorreios() {
		return uidCorreios;
	}

	public void setUidCorreios(String uidCorreios) {
		this.uidCorreios = uidCorreios;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

}
