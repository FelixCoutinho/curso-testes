package br.loja.utilidades;

public class Calculadora {

	public Integer soma(Integer primeiro, Integer segundo) {
		if (primeiro == null || segundo == null) {
			throw new RuntimeException("Não são aceitos valores nulos.");
		}
		return primeiro + segundo;
	}

}
