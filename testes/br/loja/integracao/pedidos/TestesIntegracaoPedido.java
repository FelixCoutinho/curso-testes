package br.loja.integracao.pedidos;

import java.io.InputStream;

import javax.transaction.Transactional;

import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.loja.repositorio.RepositorioPedidos;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
@Transactional
public class TestesIntegracaoPedido {

	private static final String DATASOURCE_FILE = "br/loja/integracao/datasets/pedidos/deveriaRetornarTodosOsPedidos.xml";

	@Autowired
	private IDatabaseTester databaseTester;

	@Autowired
	private RepositorioPedidos repositorioPedidos;

	@Before
	public void setUp() throws Exception {
		FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
		flatXmlDataSetBuilder.setColumnSensing(false);
		flatXmlDataSetBuilder.setCaseSensitiveTableNames(false);
		InputStream dataSet = Thread.currentThread().getContextClassLoader().getResourceAsStream(DATASOURCE_FILE);
		IDataSet dataset = flatXmlDataSetBuilder.build(dataSet);
		databaseTester.setDataSet(dataset);
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.setTearDownOperation(DatabaseOperation.DELETE);
		databaseTester.onSetup();
	}

	@Test
	public void deveriaRetornarTodosOsPedidos() {
		Assert.assertThat("Não foram encontrados os pedidos desejados.", this.repositorioPedidos.todos().size(),
				Matchers.equalTo(1));
	}

	@After
	public void down() throws Exception {
		databaseTester.onTearDown();
	}

}
