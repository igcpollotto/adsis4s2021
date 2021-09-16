package br.unicesumar.adsis4s2021.pedido;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PedidoRepository extends JpaRepository<Pedido, String> {
	
//	@Query(value = "select p.nome as produto, "
//			+ "sum(ip.quantidade * ip.preco_unitario) as \"totalVendido\" "
//			+ "from item_pedido ip "
//			+ "inner join produto p on p.id = ip.produto_id "
//			+ "group by p.nome", nativeQuery = true)
//	List<Map<String, Object>> consultarTotalVendidoPorProduto();


	@Query(value = "select p.nome as produto, "
			+ "sum(ip.quantidade * ip.precoUnitario) as totalVendido "
			+ "from ItemPedido ip "
			+ "inner join ip.produto p "
			+ "group by p.nome")
	List<Map<String, Object>> consultarTotalVendidoPorProduto();
	
	
	@Query(value = "select new br.unicesumar.adsis4s2021.pedido.TotalVendidoDoProdutoDTO(p.nome, "
			+ "sum(ip.quantidade * ip.precoUnitario)) "
			+ "from ItemPedido ip "
			+ "inner join ip.produto p "
			+ "group by p.nome")
	List<TotalVendidoDoProdutoDTO> consultarTotalVendidoPorProdutoDTO();

}
