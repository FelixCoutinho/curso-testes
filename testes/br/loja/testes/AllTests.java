package br.loja.testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.loja.dominio.TestesDominio;
import br.loja.utilidades.TestesUtilidades;

@RunWith(Suite.class)
@SuiteClasses({ TestesDominio.class, TestesUtilidades.class })
public class AllTests {

}
