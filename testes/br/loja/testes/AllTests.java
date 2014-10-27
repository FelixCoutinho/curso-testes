package br.loja.testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.loja.dominio.TestesDominio;
import br.loja.dominio.TestesMensagensCarrinho;
import br.loja.integracao.pedidos.TestesIntegracao;
import br.loja.service.TestesService;
import br.loja.utilidades.TestesUtilidades;

@RunWith(Suite.class)
@SuiteClasses({ TestesDominio.class, TestesUtilidades.class, TestesMensagensCarrinho.class, TestesService.class, TestesIntegracao.class })
public class AllTests {

}
