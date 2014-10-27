package br.loja.dominio;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestesCarrinho.class, TestesProduto.class, TestesPagamento.class, TestesPedido.class })
public class TestesDominio {

}
