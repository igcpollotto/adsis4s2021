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
	private PedidoService service;
		
	@GetMapping
	public List<PedidoDTO> getAll() {
		return service.getAll();
	}

	@PostMapping
	public String post(@RequestBody Pedido novo) {
		return service.insert(novo);
	}
	
	@GetMapping("/totalVendidoPorProduto")
	public List<Map<String, Object>> getTotalVendidoPorProduto() {
		return service.consultarTotalVendidoPorProduto();
	}

	@GetMapping("/totalVendidoPorProdutoDTO")
	public List<TotalVendidoDoProdutoDTO> getTotalVendidoPorProdutoDTO() {
		return service.consultarTotalVendidoPorProdutoDTO();
	}
}
