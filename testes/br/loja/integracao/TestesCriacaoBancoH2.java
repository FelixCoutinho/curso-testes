package br.loja.integracao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestesCriacaoBancoH2 {

	private Connection conn;

	@Before
	public void setUp() throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection("jdbc:h2:~/curso-loja", "sa", "");
	}

	@Test
	public void deveriaConectarComH2() {
		Assert.assertNotNull(conn);
	}

	@After
	public void down() throws SQLException {
		conn.close();
	}
}
