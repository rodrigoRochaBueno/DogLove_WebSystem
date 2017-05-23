package br.com.criandoSozinho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import br.com.criandoSozinho.model.Cliente;
import br.com.criandoSozinho.repository.ClientesRepository;

@Service
public class ClienteService {

	@Autowired
	ClientesRepository clientesRepository;

	public void save(Cliente cliente) {
		clientesRepository.save(cliente);
	}

	public List<Cliente> list() {
		return clientesRepository.findAll();
	}

	public List<Cliente> getByName(String nome) {
		return clientesRepository.getByName(nome);
	}

	public void delete(long id) {
		for (Cliente cli : clientesRepository.findAll()) {
			if (cli.getId() == id)
				clientesRepository.delete(cli);
		}
	}
	
	public Cliente getById(long id){
		Cliente clie = new Cliente();
		for(Cliente cli : clientesRepository.findAll()){
			if(cli.getId() == id){
				clie = cli;
			}
		}
		return clie;
	}

}