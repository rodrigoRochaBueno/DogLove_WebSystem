package br.com.criandoSozinho.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import br.com.criandoSozinho.model.Estado;


@Transactional
public interface EstadoRepository extends CrudRepository<Estado, Long>{
	
}
