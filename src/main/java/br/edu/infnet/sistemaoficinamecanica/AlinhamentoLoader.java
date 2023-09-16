package br.edu.infnet.sistemaoficinamecanica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.sistemaoficinamecanica.model.negocio.Alinhamento;
import br.edu.infnet.sistemaoficinamecanica.model.negocio.Manutencao;

@Order(2)
@Component
public class AlinhamentoLoader implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Map<Integer, Alinhamento> mapaAlinhamento = new HashMap<Integer, Alinhamento>();

		FileReader file = new FileReader("arquivos/alinhamento.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();

		String[] campos = null;

		while (linha != null) {
			campos = linha.split(";");

			Alinhamento alinhamento = new Alinhamento(
									campos[0],
									Float.valueOf(campos[1]),
									Integer.valueOf(campos[2]),			
									Boolean.valueOf(campos[3]),
									Float.valueOf(campos[4]),
									campos[5]);

			mapaAlinhamento.put(alinhamento.getCodigoServico(), alinhamento);

			linha = leitura.readLine();

		}

		for (Alinhamento alinhamento : mapaAlinhamento.values()) {
			System.out.println("[Alinhamento] Inclusão realizada com sucesso: " + alinhamento);
		}

		leitura.close();

	}
}
