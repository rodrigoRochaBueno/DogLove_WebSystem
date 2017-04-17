package br.com.criandoSozinho.model;


import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface FuncionarioRepository extends CrudRepository<Funcionarios, Long> {

}
