package br.loja.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import br.loja.dominio.Item;
import br.loja.exceptions.ServicoTerceiroException;

public class TransportadoraLigeirinhoService implements TransportadoraService {

	private static final String URL_WS_LIGEIRINHO = "http://api.ligeirinho.com/encomenda/nova";

	@Override
	public void enviarEncomenda(List<Item> items) throws ServicoTerceiroException {
		try {
			URL obj = new URL(URL_WS_LIGEIRINHO);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");

			con.setRequestProperty("User-Agent", "Mozilla/5.0");

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
			throw new ServicoTerceiroException(e);
		} catch (ProtocolException e) {
			throw new ServicoTerceiroException(e);
		} catch (IOException e) {
			throw new ServicoTerceiroException(e);
		}

	}

}
