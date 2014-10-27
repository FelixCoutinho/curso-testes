package br.loja.testes.stubs;

import java.util.List;

import br.loja.dominio.Item;
import br.loja.exceptions.ServicoTerceiroException;
import br.loja.service.TransportadoraService;

public class TransportadoraStub implements TransportadoraService {

	@Override
	public void enviarEncomenda(List<Item> items) throws ServicoTerceiroException {
		
	}

}
