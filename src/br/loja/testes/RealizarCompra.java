package br.loja.testes;

import org.junit.Assert;
import org.junit.Test;

import br.loja.dominio.Carrinho;
import br.loja.dominio.Item;
import br.loja.dominio.Produto;

public class RealizarCompra {

	@Test
	public void main() {
		Produto iPhone6 = new Produto("PRD-0001", 2399.99);
		Produto macBookPro = new Produto("PRD-0009", 7999.99);
		Produto macMini = new Produto("PRD-0009", 599.99);

		Carrinho carrinhoDeComprasCliente1 = new Carrinho();

		carrinhoDeComprasCliente1.getItens().add(new Item(macBookPro));
		carrinhoDeComprasCliente1.getItens().add(new Item(iPhone6));
		carrinhoDeComprasCliente1.getItens().add(new Item(macMini));

		Carrinho carrinhoDeComprasCliente2 = new Carrinho();

		Assert.assertEquals(Double.valueOf(10999.97),
				carrinhoDeComprasCliente1.getTotal());
		Assert.assertTrue(carrinhoDeComprasCliente1.isVazio());
		Assert.assertEquals(Double.valueOf(0.0),
				carrinhoDeComprasCliente2.getTotal());
		Assert.assertTrue(carrinhoDeComprasCliente2.isVazio());
	}

}
