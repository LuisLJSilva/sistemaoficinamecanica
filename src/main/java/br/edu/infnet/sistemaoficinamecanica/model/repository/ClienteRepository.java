package br.edu.infnet.sistemaoficinamecanica.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.sistemaoficinamecanica.model.negocio.Cliente;


@Repository // criar todos os repositories para todas classes 
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	
}
