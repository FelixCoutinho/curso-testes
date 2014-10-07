package br.loja.testes;

import static org.junit.Assume.assumeTrue;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.Test;

public class LocalhostTest {

	@Before
	public void setUp() throws UnknownHostException {
		InetAddress localHost = InetAddress.getLocalHost();
		assumeTrue(localHost.getHostAddress().equals("127.0.1.1"));
	}

	@Test
	public void deveExecutarSomenteParaLocalhost() {
		// Isso significa que estamos em localhost.
		// Teste para localhost
	}
}
