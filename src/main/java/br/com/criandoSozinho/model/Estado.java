package br.com.criandoSozinho.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Estado")
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String uf;
	
	public Estado(){
		
	}
	
	public Estado(long id, String uf){
		this.id= id;
		this.uf = uf;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	

}
