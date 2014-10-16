package br.loja.utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatadorDeData {

	public String formata(Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMM");
		return sdf.format(data);
	}

}