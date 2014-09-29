package br.loja.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.loja.dominio.Carrinho;
import br.loja.dominio.Item;
import br.loja.dominio.Produto;

public class RealizarCompra {

	@Test
	public void testes() {
		// 1 - Cenário
		Produto iPhone6 = new Produto("PRD-0001", 2399.99);
		Produto macBookPro = new Produto("PRD-0009", 7999.99);
		Produto macMini = new Produto("PRD-0009", 599.99);

		Carrinho carrinhoDeComprasCliente1 = new Carrinho();

		carrinhoDeComprasCliente1.getItens().add(new Item(macBookPro));
		carrinhoDeComprasCliente1.getItens().add(new Item(iPhone6));
		carrinhoDeComprasCliente1.getItens().add(new Item(macMini));

		Carrinho carrinhoDeComprasCliente2 = new Carrinho();

		// 2 - Ação
		double totalEsperadoCarrinho1 = 10999.97;
		double totalEsperadoCarrinho2 = 0.0;
		double totalCarrinho1 = carrinhoDeComprasCliente1.getTotal();
		double totalCarrinho2 = carrinhoDeComprasCliente2.getTotal();
		
		// 3 - Validação 
		assertEquals(totalEsperadoCarrinho1, totalCarrinho1, 0.00001);
		assertEquals(totalEsperadoCarrinho2, totalCarrinho2, 0.00001);
	}

}
