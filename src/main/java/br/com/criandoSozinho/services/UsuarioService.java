package br.com.criandoSozinho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import br.com.criandoSozinho.model.Usuario;
import br.com.criandoSozinho.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void saveUsuario(Usuario usuario){
		usuarioRepository.save(usuario);
	}
	
	public List<Usuario> listarUsuarios(){
		return usuarioRepository.findAll();
	}
	
	
	public Usuario getByName(String nome){
		return usuarioRepository.buscarPorNome(nome);
	}
	
}
