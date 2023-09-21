package br.edu.infnet.sistemaoficinamecanica.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.sistemaoficinamecanica.model.negocio.Pintura;

@Service
public class PinturaService {
	
	private Map<Integer, Pintura> mapaPintura = new HashMap<Integer, Pintura>();

	public Collection<Pintura> obterLista(){
		return mapaPintura.values();
	}
	
	public void incluir(Pintura pintura) {
		mapaPintura.put(pintura.getCodigoServico(), pintura);		
		System.out.println("[Pintura] Inclusão realizada com sucesso: " + pintura);		
	}
	
	public void excluir(int codigoServico) {
		mapaPintura.remove(codigoServico);
	}

	
}
