package br.loja.service;

import java.util.List;

import br.loja.dominio.Item;
import br.loja.exceptions.ServicoTerceiroException;

public interface TransportadoraService {

	void enviarEncomenda(List<Item> items) throws ServicoTerceiroException;
}
