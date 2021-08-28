package br.unicesumar.adsis4s2021.pedido;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	@Id 
	private String id;
	private Long numero;
	private Date emitidoEm;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pedido_id")
	private List<ItemPedido> itens;
	
	

	public Pedido() {
	}

	public String getId() {
		return id;
	}

	public Long getNumero() {
		return numero;
	}

	public Date getEmitidoEm() {
		return emitidoEm;
	}
	
	public List<ItemPedido> getItens() {
		return itens;
	}

}
