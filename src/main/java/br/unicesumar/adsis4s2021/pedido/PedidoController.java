package br.unicesumar.adsis4s2021.pedido;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicesumar.adsis4s2021.pedido.dto.PedidoDTO;
import br.unicesumar.adsis4s2021.pedido.dto.TotalVendidoDoProdutoDTO;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	@Autowired
	private PedidoRepository repo;
	
	@GetMapping
	public List<PedidoDTO> getAll() {
		List<PedidoDTO> pedidosDTO  = repo.encontrarTodosComoDTO();
		for (PedidoDTO pedidoDTO : pedidosDTO) {
			pedidoDTO.setItens(repo.encontrarItensPedidoDoPedidoDTO(pedidoDTO.getId()));
		}
		return pedidosDTO;
	}

	@PostMapping
	public String post(@RequestBody Pedido novo) {
		if (repo.findById(novo.getId()).isPresent()) {
			throw new RuntimeException("Seu pedido já existe, faça um put ao invés de post!");
		}
		novo = repo.save(novo);
		return novo.getId();
	}
	
	@GetMapping("/totalVendidoPorProduto")
	public List<Map<String, Object>> getTotalVendidoPorProduto() {
		return repo.consultarTotalVendidoPorProduto();
	}

	@GetMapping("/totalVendidoPorProdutoDTO")
	public List<TotalVendidoDoProdutoDTO> getTotalVendidoPorProdutoDTO() {
		return repo.consultarTotalVendidoPorProdutoDTO();
	}
}
