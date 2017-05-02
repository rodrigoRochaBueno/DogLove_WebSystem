package br.com.criandoSozinho.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.criandoSozinho.model.Estado;
import br.com.criandoSozinho.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	EstadoRepository estadoCrud;
	
	public void salvarEstado(Estado estado){
		estadoCrud.save(estado);
	}
	
	public Collection<Estado> getEstados(){
		return (Collection<Estado>)estadoCrud.findAll();
	}
	
	public void deleteEstado(String uf){
		for(Estado estado : estadoCrud.findAll()){
			if(estado.getUf().equals(uf)){
				estadoCrud.delete(estado);
				break;
			}
		}
	}

}
