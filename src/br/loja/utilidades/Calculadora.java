package br.loja.utilidades;

public class Calculadora {

	public static Integer somar(Integer primeiro, Integer segundo) {
		if (primeiro == null || segundo == null) {
			throw new RuntimeException("Não são aceitos valores nulos.");
		}
		return primeiro + segundo;
	}

}