package br.loja.integracao;

import java.io.InputStream;

import javax.transaction.Transactional;

import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
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

	@Autowired
	private IDatabaseTester databaseTester;

	@Before
	public void setUp() throws Exception {
		FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
		InputStream dataSet = Thread.currentThread().getContextClassLoader().getResourceAsStream("dados.xml");
		IDataSet dataset = flatXmlDataSetBuilder.build(dataSet);
		databaseTester.setDataSet(dataset);
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.setTearDownOperation(DatabaseOperation.DELETE);
		databaseTester.onSetup();
	}

	@Test
	public void deveriaSalvarPagamento() {
		this.repositorioPagamentos.salvar(CriadorDePagamento.umPagamento().criar());
	}

	@After
	public void down() throws Exception {
		databaseTester.onTearDown();
	}

}
