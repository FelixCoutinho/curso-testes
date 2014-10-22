package br.loja.integracao.dbunit;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class AbstractDbUnitTestCase {

	private static final String DRIVER = "org.h2.Driver";
	private static final String SENHA = "";
	private static final String USUARIO = "sa";
	private static final String URL = "jdbc:h2:~/curso-loja";
	private static Connection conn;
	private static IDatabaseConnection connection;
	private static IDataSet dataset;

	@BeforeClass
	public static void initConnection() throws DatabaseUnitException, ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL, USUARIO, SENHA);

		connection = new DatabaseConnection(conn);
		connection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
		connection.getConfig().setProperty(DatabaseConfig.FEATURE_CASE_SENSITIVE_TABLE_NAMES, true);
		
		FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
		InputStream dataSet = Thread.currentThread().getContextClassLoader().getResourceAsStream("dados.xml");
		dataset = flatXmlDataSetBuilder.build(dataSet);
	}

	@AfterClass
	public static void closeConnection() throws SQLException {
		conn.close();
	}

	@Before
	public void cleanDB() throws DatabaseUnitException, SQLException {
		DatabaseOperation.CLEAN_INSERT.execute(connection, dataset);
	}

	@After
	public void after() throws Exception {
		DatabaseOperation.DELETE_ALL.execute(connection, dataset);
	}
}