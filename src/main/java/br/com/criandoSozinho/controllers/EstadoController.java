package br.com.criandoSozinho.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.criandoSozinho.model.Estado;
import br.com.criandoSozinho.services.EstadoService;


@RestController
public class EstadoController {
	
	@Autowired
	EstadoService estadoService;
	
	@RequestMapping(method=RequestMethod.POST, value="/estados")
	public void salvarEstado(@RequestBody Estado estado){
		estadoService.salvarEstado(estado);
	}
	
	@GetMapping("/estados")
	public Collection<Estado> getEstados(){
		return estadoService.getEstados();
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/estados/{uf}")
	public void deleteEstado(@PathVariable String uf){
		estadoService.deleteEstado(uf);
	}

}
