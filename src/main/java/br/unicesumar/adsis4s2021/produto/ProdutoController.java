package br.unicesumar.adsis4s2021.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoRepository repo;
	
	
	@GetMapping
	public List<Produto> getProdutos() {
		return repo.findAll();
	}
	
	@PostMapping
	public String postProduto(@RequestBody Produto novo) {
		novo = repo.save(novo);
		return novo.getId();
	}	
}
