package br.unicesumar.adsis4s2021.pessoa;

import javax.persistence.Entity;

import br.unicesumar.adsis4s2021.base.BaseEntity;

@Entity
public class Pessoa extends BaseEntity {
	private String nome;
	
	public Pessoa() {
	}
	
	public Pessoa(String id, String nome) {
		super(id);
		this.nome = nome;
	}

	public String getNome() {
		return nome; 
	} 

}
