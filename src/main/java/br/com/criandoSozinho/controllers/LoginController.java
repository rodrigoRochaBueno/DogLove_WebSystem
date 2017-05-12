package br.com.criandoSozinho.controllers;

import java.util.Date;

import javax.servlet.ServletException;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.criandoSozinho.model.Usuario;
import br.com.criandoSozinho.services.UsuarioService;


@RestController
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.POST, value="/autenticar", consumes=MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse autenticar(@RequestBody Usuario usuario) throws ServletException{
		
		if(usuario.getNome() == null || usuario.getSenha() == null){
			throw new ServletException("Preencher todos os campos");
		}
		
		
		Usuario userValidado = usuarioService.getByName(usuario.getNome());
		
		if(!userValidado.getSenha().endsWith(usuario.getSenha())){
			throw new ServletException ("Usuario ou senha incorretos");
		}
		
		String token = Jwts.builder()
				.setSubject(userValidado.getNome())
				.signWith(SignatureAlgorithm.HS512, "cripto")
				.setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
				.compact();
		
		
		return new LoginResponse(token);
	}
	
	public class LoginResponse{
		public String token;
		
		public LoginResponse(String token){
			this.token=token;
		}
		
	}

}
