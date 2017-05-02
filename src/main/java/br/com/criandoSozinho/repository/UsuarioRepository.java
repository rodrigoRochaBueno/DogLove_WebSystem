package br.com.criandoSozinho.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.criandoSozinho.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query(value="Select u from Usuario u where u.nome=:pnome")
	public Usuario buscarPorNome(@Param("pnome")String nome);
	
}
