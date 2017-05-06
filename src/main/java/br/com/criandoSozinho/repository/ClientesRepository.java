package br.com.criandoSozinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.criandoSozinho.model.Cliente;



public interface ClientesRepository extends JpaRepository<Cliente, Long>{

}

