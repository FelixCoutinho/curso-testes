package br.loja.dominio;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.loja.dominio.databuilders.CriadorDeCarrinho;
import br.loja.dominio.databuilders.CriadorDeProduto;

public class TestesMensagensCarrinho {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void deveriaNaoPermitirAdicionarItemDiretamenteAoCarrinho() {
		thrown.expect(RuntimeException.class);
	    thrown.expectMessage("Não é permitido adicionar itens dessa forma.");
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().criar();
		carrinho.getItens().add(new Item(CriadorDeProduto.umProduto().criar()));		
	}

}
