package br.edu.infnet.sistemaoficinamecanica.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.sistemaoficinamecanica.model.negocio.Manutencao;

@Controller
public class ManutencaoController {

	private Map<String, Manutencao> mapaManutencao = new HashMap<String, Manutencao>();

	public Collection<Manutencao> obterLista(){
		return mapaManutencao.values();
	}
	
	public void incluir(Manutencao manutencao) {
		mapaManutencao.put(manutencao.getTipoManutencao(), manutencao);		
		System.out.println("[Manutencao] Inclusão realizada com sucesso: " + manutencao);		
	}
	
	public void excluir(String tipoManutencao) {
		mapaManutencao.remove(tipoManutencao);
	}

	@GetMapping(value = "/manutencao/lista")
	public String telaLista(Model model) {

		model.addAttribute("listaManutencao", obterLista());
		
		return "manutencao/lista";
	}

	@GetMapping(value = "/manutencao/{tipoManutencao}/excluir") 
	public String exclusao(@PathVariable String tipoManutencao) {
		
		excluir(tipoManutencao);

		return "redirect:/manutencao/lista";
	}


}
