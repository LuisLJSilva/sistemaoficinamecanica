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

@Order(1)
@Component
public class ManutencaoLoader implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Map<Integer, Manutencao> mapaManutencao = new HashMap<Integer, Manutencao>();

		FileReader file = new FileReader("arquivos/manutencao.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();

		String[] campos = null;

		while (linha != null) {
			campos = linha.split(";");

			Manutencao manutencao = new Manutencao(campos[0], Float.valueOf(campos[1]), Integer.valueOf(campos[2]),
					Boolean.valueOf(campos[3]), Float.valueOf(campos[4]), campos[5]);

			mapaManutencao.put(manutencao.getId(), manutencao);

			linha = leitura.readLine();

		}

		for (Manutencao manutencao : mapaManutencao.values()) {
			System.out.println("[Manutencao] Inclusão realizada com sucesso: " + manutencao);
		}

		leitura.close();

	}
}
