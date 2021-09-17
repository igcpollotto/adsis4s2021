package br.unicesumar.adsis4s2021.pedido.dto;

import java.math.BigDecimal;

public class ItemPedidoDTO {
	private String id;
	private BigDecimal precoUnitario;
	private BigDecimal percentualDeDesconto;
	private BigDecimal quantidade;
	private String produtoId;
	private String produtoNome;
	public ItemPedidoDTO(String id, BigDecimal precoUnitario, BigDecimal percentualDeDesconto, BigDecimal quantidade,
			String produtoId, String produtoNome) {
		super();
		this.id = id;
		this.precoUnitario = precoUnitario;
		this.percentualDeDesconto = percentualDeDesconto;
		this.quantidade = quantidade;
		this.produtoId = produtoId;
		this.produtoNome = produtoNome;
	}
	public String getId() {
		return id;
	}
	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}
	public BigDecimal getPercentualDeDesconto() {
		return percentualDeDesconto;
	}
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	public String getProdutoId() {
		return produtoId;
	}
	public String getProdutoNome() {
		return produtoNome;
	}
}
