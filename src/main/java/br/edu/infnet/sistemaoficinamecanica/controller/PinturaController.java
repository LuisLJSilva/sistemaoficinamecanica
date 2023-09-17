package br.edu.infnet.sistemaoficinamecanica.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.sistemaoficinamecanica.model.negocio.Pintura;

@Controller
public class PinturaController {

	private Map<String, Pintura> mapaPintura = new HashMap<String, Pintura>();

	public Collection<Pintura> obterLista(){
		return mapaPintura.values();
	}
	
	public void incluir(Pintura pintura) {
		mapaPintura.put(pintura.getCor(), pintura);		
		System.out.println("[Pintura] Inclusão realizada com sucesso: " + pintura);		
	}
	
	public void excluir(String cor) {
		mapaPintura.remove(cor);
	}

	@GetMapping(value = "/pintura/lista")
	public String telaLista(Model model) {

		model.addAttribute("listaPintura", obterLista());
		
		return "pintura/lista";
	}

	@GetMapping(value = "/pintura/{cor}/excluir") 
	public String exclusao(@PathVariable String cor) {
		
		excluir(cor);

		return "redirect:/pintura/lista";
	}


}
