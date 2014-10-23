package br.loja.repositorio;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.loja.dominio.Pagamento;

@Repository
public class RepositorioPagamentosPadrao implements RepositorioPagamentos {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void salvar(Pagamento pagamento) {
		this.getCurrentSession().save(pagamento);
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
