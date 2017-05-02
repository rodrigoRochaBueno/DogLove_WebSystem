package br.com.criandoSozinho.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String senha;
	
	
	public Usuario(){
		
	}
	
	public Usuario(String nome, String senha){
		this.nome=nome;
		this.senha=senha;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
