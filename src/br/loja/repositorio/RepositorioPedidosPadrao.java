package br.loja.repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.loja.dominio.Pedido;

@Repository
@Transactional
public class RepositorioPedidosPadrao implements RepositorioPedidos {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> todos() {
		return this.getCurrentSession().createCriteria(Pedido.class).list();
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
