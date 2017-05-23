package br.com.criandoSozinho.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.criandoSozinho.model.Cliente;
import br.com.criandoSozinho.services.ClienteService;

@RestController
@RequestMapping("/security/v1/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	// Salva um Objeto do tipo Cliente no DB
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveClient(@RequestBody Cliente cliente,
			HttpServletResponse response) {

		clienteService.save(cliente);

		response.addHeader("Location", "/security/v1/clientes");
		response.setStatus(201);

		return;
	}

	// Retorna uma lista de Objetos do tipo Cliente do DB
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> listClients(HttpServletResponse response) {

		response.addHeader("Location", "/security/v1/clientes");
		response.setStatus(200);

		return clienteService.list();
	}

	// Retorna um Objeto do tipo Cliente do DB pelo atributo "nome"
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/nome={nome}")
	public List<Cliente> getName(@PathVariable String nome,
			HttpServletResponse response) {

		response.addHeader("Location0", "/security/v1/clientes/" + nome);
		response.setStatus(200);

		return clienteService.getByName(nome);
	}

	// Retorna um Objeto do tipo Cliente do DB pelo atributo "id"
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
	public Cliente getId(@PathVariable long id, HttpServletResponse response) {

		response.addHeader("Location", "/security/v1/clientes/" + id);
		response.setStatus(200);

		return clienteService.getById(id);
	}

	// Deleta um objeto do tipo Cliente do DB pelo atributo "id"
	@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
	public void deletarCliente(@PathVariable long id,
			HttpServletResponse response) {

		response.addHeader("Location", "/security/v1/clientes/" + id);
		response.setStatus(204);

		clienteService.delete(id);

		return;

	}

}
