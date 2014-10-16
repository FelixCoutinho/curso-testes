package br.loja.testes;

import java.math.BigDecimal;

import org.junit.Test;

import br.loja.dominio.Carrinho;
import br.loja.dominio.Produto;
import br.loja.service.FinalizadorDeCompras;
import br.loja.service.FinalizadorDeComprasPadrao;
import br.loja.service.ProcessadorDePagamentoPadrao;
import br.loja.testes.builders.CriadorDeCarrinho;
import br.loja.testes.builders.CriadorDeProduto;
import br.loja.testes.stubs.TransportadoraStub;

public class EnvioTest {

	private FinalizadorDeCompras finalizadorDeCompras = new FinalizadorDeComprasPadrao(new TransportadoraStub(),
			new ProcessadorDePagamentoPadrao());

	@Test
	public void deveEnviarUmaCompra() {
		Produto produto = CriadorDeProduto.umProduto().comSKU("PRD-0001").comPreco(BigDecimal.valueOf(2399.99)).criar();
		Carrinho carrinho = CriadorDeCarrinho.umCarrinho().criar();
		carrinho.adicionar(produto);
		this.finalizadorDeCompras.finalizarCompra(carrinho);
	}

}
