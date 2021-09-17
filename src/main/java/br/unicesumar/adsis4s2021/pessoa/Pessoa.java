package br.unicesumar.adsis4s2021.pessoa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.unicesumar.adsis4s2021.base.BaseEntity;

@Entity
public class Pessoa extends BaseEntity {
	private String nome;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="morador_id")
	private List<Endereco> enderecos = new ArrayList<>();
	
	public Pessoa() {
	}
	
	public Pessoa(String id, String nome) {
		super(id);
		this.nome = nome;
	}

	public String getNome() {
		return nome; 
	} 
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//@JsonIgnore
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
		
}
