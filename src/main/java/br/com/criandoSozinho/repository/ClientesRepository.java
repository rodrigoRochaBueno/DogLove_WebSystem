package br.com.criandoSozinho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.criandoSozinho.model.Cliente;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Long>{
	
	@Query(value="SELECT cli FROM Cliente cli WHERE cli.nome LIKE :pnome%")
	public List<Cliente> getByName(@Param("pnome")String nome);

}

