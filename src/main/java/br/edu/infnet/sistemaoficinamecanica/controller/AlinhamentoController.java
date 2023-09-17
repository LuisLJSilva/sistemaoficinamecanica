package br.edu.infnet.sistemaoficinamecanica.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.sistemaoficinamecanica.model.negocio.Alinhamento;

@Controller
public class AlinhamentoController {

	private Map<String, Alinhamento> mapaAlinhamento = new HashMap<String, Alinhamento>();

	public Collection<Alinhamento> obterLista(){
		return mapaAlinhamento.values();
	}
	
	public void incluir(Alinhamento alinhamento) {
		mapaAlinhamento.put(alinhamento.getCondicaoPneus(), alinhamento);		
		System.out.println("[Alinhamento] Inclusão realizada com sucesso: " + alinhamento);		
	}
	
	public void excluir(String condicaoPneus) {
		mapaAlinhamento.remove(condicaoPneus);
	}

	@GetMapping(value = "/alinhamento/lista")
	public String telaLista(Model model) {

		model.addAttribute("listaAlinhamento", obterLista());
		
		return "alinhamento/lista";
	}

	@GetMapping(value = "/alinhamento/{condicaoPneus}/excluir") 
	public String exclusao(@PathVariable String condicaoPneus) {
		
		excluir(condicaoPneus);

		return "redirect:/alinhamento/lista";
	}


}
