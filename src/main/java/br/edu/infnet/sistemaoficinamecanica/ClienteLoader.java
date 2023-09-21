package br.edu.infnet.sistemaoficinamecanica;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import br.edu.infnet.sistemaoficinamecanica.model.negocio.Cliente;
import br.edu.infnet.sistemaoficinamecanica.model.service.ClienteService;

@Order(4)
@Component
@Controller
public class ClienteLoader implements ApplicationRunner {
	
	@Autowired
	private ClienteService clienteService;
		
	@Override
	public void run(ApplicationArguments args) throws Exception {
				 
		FileReader file = new FileReader("arquivos/cliente.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null) {
			campos = linha.split(";");
			
			Cliente cliente = new Cliente(
					campos[0],
					campos[1],
					campos[2]
					);
			
			clienteService.incluir(cliente);
			
			
			linha = leitura.readLine();				
		}
		
		leitura.close();
	}

}
