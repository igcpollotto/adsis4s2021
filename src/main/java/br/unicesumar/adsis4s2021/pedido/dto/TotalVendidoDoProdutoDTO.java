package br.unicesumar.adsis4s2021.pedido.dto;

import java.math.BigDecimal;

public class TotalVendidoDoProdutoDTO {
	public String produto;
	public BigDecimal totalVendido;
	
	public TotalVendidoDoProdutoDTO(String produto, BigDecimal totalVendido) {
		this.produto = produto;
		this.totalVendido = totalVendido;
	}
	
	

}
