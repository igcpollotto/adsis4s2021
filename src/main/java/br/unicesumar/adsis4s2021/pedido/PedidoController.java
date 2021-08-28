package br.unicesumar.adsis4s2021.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	@Autowired
	private PedidoRepository repo;
	
	@GetMapping
	public List<Pedido> getAll() {
		return repo.findAll();
	}

	@PostMapping
	public String post(@RequestBody Pedido novo) {
		if (repo.findById(novo.getId()).isPresent()) {
			throw new RuntimeException("Seu pedido já existe, faça um put ao invés de post!");
		}
		novo = repo.save(novo);
		return novo.getId();
	}

}
