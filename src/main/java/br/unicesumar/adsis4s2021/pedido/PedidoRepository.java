package br.unicesumar.adsis4s2021.pedido;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.unicesumar.adsis4s2021.pedido.dto.ItemPedidoDTO;
import br.unicesumar.adsis4s2021.pedido.dto.PedidoDTO;
import br.unicesumar.adsis4s2021.pedido.dto.TotalVendidoDoProdutoDTO;

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
	
	
	@Query(value = "select new br.unicesumar.adsis4s2021.pedido.dto.TotalVendidoDoProdutoDTO(p.nome, "
			+ "sum(ip.quantidade * ip.precoUnitario)) "
			+ "from ItemPedido ip "
			+ "inner join ip.produto p "
			+ "group by p.nome")
	List<TotalVendidoDoProdutoDTO> consultarTotalVendidoPorProdutoDTO();


	@Query(value = "select new br.unicesumar.adsis4s2021.pedido.dto.PedidoDTO(p.id, p.numero, p.emitidoEm, c.id, c.nome) "
			+ "from Pedido p "
			+ "inner join p.cliente c")
	List<PedidoDTO> encontrarTodosComoDTO();
	
	@Query(value = "select new br.unicesumar.adsis4s2021.pedido.dto.ItemPedidoDTO(ip.id, ip.quantidade, ip.percentualDeDesconto, ip.precoUnitario, prod.id, prod.nome) "
			+ "from Pedido p "
			+ "inner join p.itens ip "
			+ "inner join ip.produto prod "
			+ "where p.id = :pedidoId")
	List<ItemPedidoDTO> encontrarItensPedidoDoPedidoDTO(String pedidoId);


}
