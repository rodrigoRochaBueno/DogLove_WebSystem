package br.com.criandoSozinho.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.criandoSozinho.model.Cliente;
import br.com.criandoSozinho.services.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@PostMapping("/salvar")
	public void saveCliente(@RequestBody Cliente cliente) {
		clienteService.salvarCliente(cliente);
	}

	@GetMapping("/listarClientes")
	public List<Cliente> listar() {
		return clienteService.getClientes();
	}

}
