package br.loja.testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CarrinhoTest.class, ProdutoTest.class, CalculadoraTest.class, EnvioTest.class })
public class AllTests {

}
