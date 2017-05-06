package br.com.criandoSozinho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.criandoSozinho.model.Cliente;
import br.com.criandoSozinho.repository.ClientesRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClientesRepository clientesRepository;
	
	public void salvarCliente(Cliente cliente){
		clientesRepository.save(cliente);
	}
	
	public List<Cliente> getClientes(){
		return clientesRepository.findAll();
	}

}