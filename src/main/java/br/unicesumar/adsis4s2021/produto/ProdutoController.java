package br.unicesumar.adsis4s2021.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoRepository repo;

	
	@DeleteMapping("/{id}")
	public void deletePeloId(@PathVariable("id") String id) {
		repo.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Produto getPeloId(@PathVariable("id") String id) {
		return repo.findById(id).get();
	}

	
	@GetMapping
	public List<Produto> getAll() {
		return repo.findAll();
	}
	
	@PostMapping
	public String post(@RequestBody Produto novo) {
		novo = repo.save(novo);
		return novo.getId();
	}	
}
