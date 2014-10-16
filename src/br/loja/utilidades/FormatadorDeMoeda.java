package br.loja.utilidades;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatadorDeMoeda {

	private static NumberFormat formatadorPadrao = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

	public static String formatar(BigDecimal valor) {
		formatadorPadrao.setMinimumFractionDigits(1);
		formatadorPadrao.setMaximumFractionDigits(2);
		return formatadorPadrao.format(valor.doubleValue());
	}
}
