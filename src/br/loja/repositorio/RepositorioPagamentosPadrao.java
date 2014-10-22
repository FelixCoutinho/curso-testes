package br.loja.repositorio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.loja.dominio.Pagamento;

public class RepositorioPagamentosPadrao implements RepositorioPagamentos {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void salvar(Pagamento pagamento) {

	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
