package br.unicesumar.adsis4s2021.pedido;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unicesumar.adsis4s2021.estoque.ReservaDeEstoque;
import br.unicesumar.adsis4s2021.estoque.ReservaDeEstoqueService;
import br.unicesumar.adsis4s2021.pedido.dto.PedidoDTO;
import br.unicesumar.adsis4s2021.pedido.dto.TotalVendidoDoProdutoDTO;

@Service
@Transactional
public class PedidoService {
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private ReservaDeEstoqueService reservaDeEstoqueSevice;

	public List<PedidoDTO> getAll() {
		List<PedidoDTO> pedidosDTO  = repo.encontrarTodosComoDTO();
		for (PedidoDTO pedidoDTO : pedidosDTO) {
			pedidoDTO.setItens(repo.encontrarItensPedidoDoPedidoDTO(pedidoDTO.getId()));
		}
		return pedidosDTO;
	}

	public String insert(Pedido novo) {
		if (repo.findById(novo.getId()).isPresent()) {
			throw new RuntimeException("Seu pedido já existe, faça um put ao invés de post!");
		}
		
		for (ItemPedido ip : novo.getItens()) {
			reservaDeEstoqueSevice.insert(new ReservaDeEstoque(novo.getCliente(), new Date(), ip.getProduto(), ip.getQuantidade()));
		}
		if ((10-10) == 0 ) {
			throw new RuntimeException("Rollback!");
		}		
		novo = repo.save(novo);
		return novo.getId();
	}

	public List<Map<String, Object>> consultarTotalVendidoPorProduto() {
		return repo.consultarTotalVendidoPorProduto();	
	}

	public List<TotalVendidoDoProdutoDTO> consultarTotalVendidoPorProdutoDTO() {
		return repo.consultarTotalVendidoPorProdutoDTO();
	}


}
