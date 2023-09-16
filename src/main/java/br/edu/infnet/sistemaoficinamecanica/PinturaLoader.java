package br.edu.infnet.sistemaoficinamecanica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.sistemaoficinamecanica.model.negocio.Manutencao;
import br.edu.infnet.sistemaoficinamecanica.model.negocio.Pintura;

@Order(3)
@Component
public class PinturaLoader implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Map<Integer, Pintura> mapaPintura = new HashMap<Integer, Pintura>();

		FileReader file = new FileReader("arquivos/pintura.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();

		String[] campos = null;

		while (linha != null) {
			campos = linha.split(";");

			Pintura pintura = new Pintura(
							  campos[0],
							  Float.valueOf(campos[1]),
							  Integer.valueOf(campos[2]),
							  Boolean.valueOf(campos[3]),
							  Float.valueOf(campos[4]),
							  campos[5]);

			mapaPintura.put(pintura.getCodigoServico(), pintura);

			linha = leitura.readLine();

		}

		for (Pintura pintura : mapaPintura.values()) {
			System.out.println("[Pintura] Inclusão realizada com sucesso: " + pintura);
		}

		leitura.close();

	}
}
