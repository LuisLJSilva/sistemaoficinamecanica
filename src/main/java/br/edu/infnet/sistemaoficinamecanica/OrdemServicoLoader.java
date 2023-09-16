package br.edu.infnet.sistemaoficinamecanica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.sistemaoficinamecanica.model.negocio.Alinhamento;
import br.edu.infnet.sistemaoficinamecanica.model.negocio.Cliente;
import br.edu.infnet.sistemaoficinamecanica.model.negocio.Manutencao;
import br.edu.infnet.sistemaoficinamecanica.model.negocio.OrdemServico;
import br.edu.infnet.sistemaoficinamecanica.model.negocio.Pintura;
import br.edu.infnet.sistemaoficinamecanica.model.negocio.Servico;

@Order(5)
@Component
public class OrdemServicoLoader implements ApplicationRunner {
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Map<LocalDateTime, OrdemServico> mapaOrdemServico = new HashMap<LocalDateTime, OrdemServico>();
		
		FileReader file = new FileReader("arquivos/ordemservico.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		OrdemServico ordemServico = null;
		
		while(linha != null) {
			campos = linha.split(";");
			
			switch (campos[0]) {
			case "OS":
				
				ordemServico = new OrdemServico(
						campos[1],
						new Cliente(campos[2], campos[3], campos[4]),
						new ArrayList<Servico>()
					);
				
				mapaOrdemServico.put(ordemServico.getDataAgendamento(), ordemServico);
				
				break;
				
			case "M":
				Manutencao manutencao = new Manutencao(
						campos[1],
						Float.valueOf(campos[2]),
						Integer.valueOf(campos[3]),
						Boolean.valueOf(campos[4]),
						Float.valueOf(campos[5]),
						campos[6]
					);
				
				ordemServico.getServicos().add(manutencao);
				
				break;
				
			case "P":
				Pintura pintura = new Pintura(
						campos[1],
						Float.valueOf(campos[2]),
						Integer.valueOf(campos[3]),
						Boolean.valueOf(campos[4]),
						Float.valueOf(campos[5]),
						campos[6]
					);
				
				ordemServico.getServicos().add(pintura);
				
				break;
				
			case "A":
				Alinhamento alinhamento = new Alinhamento(
						campos[1],
						Float.valueOf(campos[2]),
						Integer.valueOf(campos[3]),
						Boolean.valueOf(campos[4]),
						Float.valueOf(campos[5]),
						campos[6]
					);
				
				ordemServico.getServicos().add(alinhamento);
				
				break;
				
			default:
				break;
			}
			
			linha = leitura.readLine();			
		}
		
		for(OrdemServico os : mapaOrdemServico.values()) {
			System.out.println("[Ordem de Serviço] Inclusão realizada com sucesso: " + os);
		}
		
		leitura.close();		 
	} 

}
