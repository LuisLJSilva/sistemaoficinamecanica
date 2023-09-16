package br.edu.infnet.sistemaoficinamecanica.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.sistemaoficinamecanica.ClienteLoader;
import br.edu.infnet.sistemaoficinamecanica.model.negocio.Cliente;

@Controller
public class ClienteController {
	
	private Map<String, Cliente> mapaCliente = new HashMap<String, Cliente>();
	
	public Collection<Cliente> obterLista(){
		return mapaCliente.values();
	}
	
	public void incluir(Cliente cliente) {
		mapaCliente.put(cliente.getCpf(), cliente);
		System.out.println("[Cliente] Inclusão realizada com sucesso: " + cliente);
	}
	
	public void excluir (String cpf) {
		mapaCliente.remove(cpf);
	}
	
	@GetMapping(value = "/cliente/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("listaCliente", obterLista());
		
		return "cliente/lista";
	}
		
	@GetMapping(value = "/cliente/{cpf}/excluir")
	public String exclusao(@PathVariable String cpf) {
		
		System.out.println();
		
		return "cliente/lista";
	}


}
