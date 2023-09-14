package br.edu.infnet.sistemaoficinamecanica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.sistemaoficinamecanica.controller.ClienteController;
import br.edu.infnet.sistemaoficinamecanica.model.negocio.Cliente;

@Order(4)
@Component
@Controller
public class ClienteLoader implements ApplicationRunner {
	
	private Map<String, Cliente> mapaCliente;
	
	@Autowired
	private ClienteController clienteController;
	
	public Collection<Cliente> obterClientes(){
		return mapaCliente.values();
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		mapaCliente = new HashMap<String, Cliente>();
		
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
			
			mapaCliente.put(cliente.getCpf(), cliente);
			
			linha = leitura.readLine();				
		}
		
		for(Cliente cliente : mapaCliente.values()) {
			System.out.println("[Cliente] Inclusão realizada com sucesso: " + cliente);
		}
		
//		ClienteController.setClientes(mapaCliente.values());
		
		leitura.close();
	}
	
//	@GetMapping(value = "/cliente/lista")
//	public String telaLista(Model model) {
//		
//		model.addAttribute("listaCliente", clienteLoader.obterLista());
//		
//		return "cliente/lista";
//	}

}
