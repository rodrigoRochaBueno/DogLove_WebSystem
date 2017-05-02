package br.com.criandoSozinho.services;



import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.criandoSozinho.model.Funcionarios;
import br.com.criandoSozinho.repository.FuncionarioRepository;


@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	public Funcionarios getFunc(String nome){
		Funcionarios func = new Funcionarios();
		for(Funcionarios f1 : funcionarioRepository.findAll()){
			if(f1.getNome().equals(nome)){
				func = f1;
				break;
			}
		}return func;
	}
	
	public Collection<Funcionarios> getFunc(){
		return (Collection<Funcionarios>) funcionarioRepository.findAll();
	}
	
	public void addFunc(Funcionarios funcionario){
		funcionarioRepository.save(funcionario);
	}
	
	
	public void deleteFunc(String nome){
		for(Funcionarios i : funcionarioRepository.findAll()){
			if(i.getNome().equals(nome))
				funcionarioRepository.delete(i);
		}
	}
	
	public void putFunc(long id, Funcionarios f){
		for(Funcionarios i: funcionarioRepository.findAll()){
			if(i.getId() == id){
				i = f;
			}
		}
	}
	
}


