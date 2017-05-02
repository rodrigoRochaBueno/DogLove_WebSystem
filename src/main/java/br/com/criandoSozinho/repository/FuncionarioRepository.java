package br.com.criandoSozinho.repository;


import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import br.com.criandoSozinho.model.Funcionarios;

@Transactional
public interface FuncionarioRepository extends CrudRepository<Funcionarios, Long> {

}
