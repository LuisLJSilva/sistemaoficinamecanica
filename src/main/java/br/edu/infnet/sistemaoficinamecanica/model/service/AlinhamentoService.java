package br.edu.infnet.sistemaoficinamecanica.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.sistemaoficinamecanica.model.negocio.Alinhamento;

@Service
public class AlinhamentoService {
	
	private Map<Integer, Alinhamento> mapaAlinhamento = new HashMap<Integer, Alinhamento>();

	public Collection<Alinhamento> obterLista(){
		return mapaAlinhamento.values();
	}
	
	public void incluir(Alinhamento alinhamento) {
		mapaAlinhamento.put(alinhamento.getCodigoServico(), alinhamento);		
		System.out.println("[Alinhamento] Inclusão realizada com sucesso: " + alinhamento);		
	}
	
	public void excluir(int getCodigoServico) {
		mapaAlinhamento.remove(getCodigoServico);
	}
	
}
