package br.com.criandoSozinho.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "funcionarios")
public class Funcionarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private double salario;
	private String setor;
	@JoinColumn
	@ManyToOne
	private Estado estado;
	
	public Funcionarios(){
		
	}
	
	public Funcionarios(String nome, double salario, String setor) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.setor = setor;
	}
	
	public long getId(){
		return this.id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

}
