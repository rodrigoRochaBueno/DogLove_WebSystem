package br.com.criandoSozinho.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.criandoSozinho.model.Usuario;
import br.com.criandoSozinho.services.UsuarioService;


@RestController
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping(method=RequestMethod.POST, value="/usuarios", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void salvarUsuario(@RequestBody Usuario usuario){
		usuarioService.saveUsuario(usuario);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/usuarios")
	public List<Usuario> getUsuarios(){
		return usuarioService.listarUsuarios();
	}
	
}
