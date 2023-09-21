package br.edu.infnet.sistemaoficinamecanica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.sistemaoficinamecanica.model.domain.Cliente;
import br.edu.infnet.sistemaoficinamecanica.model.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public Collection<Cliente> obterLista(){
		
		return (Collection<Cliente>) clienteRepository.findAll();
		
	}
	
	public void incluir(Cliente cliente) {
		
		clienteRepository.save(cliente);
	}
	
	public void excluir(Integer id) {
	
		clienteRepository.deleteById(id);
	}

	
}
