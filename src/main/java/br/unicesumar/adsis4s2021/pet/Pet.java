package br.unicesumar.adsis4s2021.pet;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pet {
	@Id
	private String id;
	private String nome;
	
	public Pet() {
	}
	
	public Pet(String id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public String getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
}
