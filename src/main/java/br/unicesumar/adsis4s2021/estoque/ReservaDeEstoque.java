package br.unicesumar.adsis4s2021.estoque;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.unicesumar.adsis4s2021.base.BaseEntity;
import br.unicesumar.adsis4s2021.pessoa.Pessoa;
import br.unicesumar.adsis4s2021.produto.Produto;

@Entity
public class ReservaDeEstoque extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Pessoa cliente;
	private Date efetuadaEm;
	@ManyToOne
	private Produto produto;
	private BigDecimal quantidade;

	
	
	public ReservaDeEstoque(Pessoa cliente, Date efetuadaEm, Produto produto, BigDecimal quantidade) {
		super();
		this.cliente = cliente;
		this.efetuadaEm = efetuadaEm;
		this.produto = produto;
		this.quantidade = quantidade;
	}


	public ReservaDeEstoque() {
		super();
	}


	public Pessoa getCliente() {
		return cliente;
	}


	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}


	public Date getEfetuadaEm() {
		return efetuadaEm;
	}


	public void setEfetuadaEm(Date efetuadaEm) {
		this.efetuadaEm = efetuadaEm;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
