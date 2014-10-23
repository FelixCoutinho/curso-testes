package br.loja.integracao;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.loja.dominio.databuilders.CriadorDePagamento;
import br.loja.repositorio.RepositorioPagamentos;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
@Transactional
public class TestesSalvarPagamento {

	@Autowired
	private RepositorioPagamentos repositorioPagamentos;

	@Before
	public void setUp() {
		this.repositorioPagamentos.salvar(CriadorDePagamento.umPagamento().criar());
	}

	@Test
	public void deveriaSalvarPagamento() {

	}

	@After
	public void down() {

	}
}
