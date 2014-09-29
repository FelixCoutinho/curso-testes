package br.loja.testes;

import br.loja.dominio.Carrinho;
import br.loja.dominio.Item;
import br.loja.dominio.Produto;

public class RealizarCompra {

	public static void main(String[] args) {
		Produto iPhone6 = new Produto("PRD-0001", 2399.99);
		Produto macBookPro = new Produto("PRD-0009", 7999.99);
		Produto macMini = new Produto("PRD-0009", 599.99);

		Carrinho carrinhoDeComprasCliente1 = new Carrinho();

		carrinhoDeComprasCliente1.getItens().add(new Item(macBookPro));
		carrinhoDeComprasCliente1.getItens().add(new Item(iPhone6));
		carrinhoDeComprasCliente1.getItens().add(new Item(macMini));
		
		Carrinho carrinhoDeComprasCliente2 = new Carrinho();
		
		System.out.println(carrinhoDeComprasCliente1.getTotal());
		
		System.out.println(carrinhoDeComprasCliente2.getTotal());
	}

}
