package br.unicesumar.adsis4s2021.estoque;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservaDeEstoqueRepository extends JpaRepository<ReservaDeEstoque, String>{

	@Query(value = "select coalesce(sum(r.quantidade),0.0) as quantidade "
			+ "        from reserva_de_estoque r"
			+ "       where r.cliente_id = :clienteId"
			+ "         and r.produto_id = :produtoId",
			nativeQuery = true)
	BigDecimal recuperarQuantidadeTotalJáReservada(String clienteId, String produtoId);

}
