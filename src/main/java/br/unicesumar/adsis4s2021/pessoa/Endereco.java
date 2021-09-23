package br.unicesumar.adsis4s2021.pessoa;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.unicesumar.adsis4s2021.base.BaseEntity;
import br.unicesumar.adsis4s2021.cidade.Cidade;

@Entity
public class Endereco extends BaseEntity {
	private String logradouro;
	private String numero;
	private String bairro;
	@ManyToOne
	private Cidade cidade;
	
	public Endereco() {
		super();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	
	
	

}
