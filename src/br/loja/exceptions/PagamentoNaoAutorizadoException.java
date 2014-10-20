package br.loja.exceptions;

public class PagamentoNaoAutorizadoException extends Exception {

	private static final long serialVersionUID = -6099184173872449045L;

	public PagamentoNaoAutorizadoException(String message) {
		super(message);
	}
	
}
