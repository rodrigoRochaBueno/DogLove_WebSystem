package br.com.criandoSozinho.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.criandoSozinho.model.Funcionarios;
import br.com.criandoSozinho.services.FuncionarioService;


@RestController("/admin")
public class ControllerTest {
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@RequestMapping(method=RequestMethod.GET, value="/funcionarios")
	public Collection<Funcionarios> ListFuncionarios(){
		return funcionarioService.getFunc();
	}
	
	@RequestMapping("/funcionarios/{nome}")
	public Funcionarios getFunc(@PathVariable String nome){
		return funcionarioService.getFunc(nome);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/funcionarios")
	public void addFunc(@RequestBody Funcionarios funcionario){
		funcionarioService.addFunc(funcionario);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/funcionarios/{nome}")
	public void deleteFunc(@PathVariable String nome){
		funcionarioService.deleteFunc(nome);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/funcionarios/{id}")
	public void putFunc(@PathVariable long id, @RequestBody Funcionarios func ){
		funcionarioService.putFunc(id, func);
	}
}
