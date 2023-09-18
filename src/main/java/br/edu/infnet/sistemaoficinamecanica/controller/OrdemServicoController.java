package br.edu.infnet.sistemaoficinamecanica.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.sistemaoficinamecanica.model.negocio.OrdemServico;
import br.edu.infnet.sistemaoficinamecanica.model.negocio.Pintura;

@Controller
public class OrdemServicoController {

	private Map<String, OrdemServico> mapaOrdemServico = new HashMap<String, OrdemServico>();

	public Collection<OrdemServico> obterLista(){
		return mapaOrdemServico.values();
	}
	
	public void incluir(OrdemServico ordemServico) {
		mapaOrdemServico.put(ordemServico.getStatus(), ordemServico);		
		System.out.println("[OrdemServico] Inclusão realizada com sucesso: " + ordemServico);		
	}
	
	public void excluir(String status) {
		mapaOrdemServico.remove(status);
	}

	@GetMapping(value = "/ordemservico/lista")
	public String telaLista(Model model) {

		model.addAttribute("listaOrdemServico", obterLista());
		
		return "ordemservico/lista";
	}

	@GetMapping(value = "/ordemservico/{status}/excluir") 
	public String exclusao(@PathVariable String status) {
		
		excluir(status);

		return "redirect:/ordemservico/lista";
	}

}
