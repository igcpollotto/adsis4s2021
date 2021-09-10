package br.unicesumar.adsis4s2021.cidade;

import javax.persistence.Entity;

import br.unicesumar.adsis4s2021.base.BaseEntity;

@Entity
public class Cidade extends BaseEntity {
	private String nome;
	
	public Cidade() {
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
		
}
