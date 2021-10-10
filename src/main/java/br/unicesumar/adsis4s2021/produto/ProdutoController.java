package br.unicesumar.adsis4s2021.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.unicesumar.adsis4s2021.base.BadRequestException;
import br.unicesumar.adsis4s2021.base.NotFoundException;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoRepository repo;

	
	@GetMapping("/com-preço-maior-que")
	public List<Produto> getComPreçoMaiorQue(@RequestParam double preço) {
		//return repo.recuperarPreçoMaiorQue(preço);
		return repo.recuperarPreçoMaiorQueViaSQL(preço);
	}
	
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
		System.out.println(">>>>> " +   repo.getClass().getName());
		return repo.findAll();
	}
	
	@PostMapping
	public String post(@RequestBody Produto novo) {
		if (repo.findById(novo.getId()).isPresent()) {
			throw new RuntimeException("Seu produto já existe, faça um put ao invés de post!");
		}
		novo = repo.save(novo);
		return novo.getId();
	}
	
//	@PutMapping("/{id}")
//	public String put(@RequestBody Produto modificado, @PathVariable("id") String id) {
//		if (!modificado.getId().equals(id)) {
//			throw new RuntimeException("Para atualizar um produto, os IDs do request devem ser iguais!");
//		}
//		if (!repo.findById(id).isPresent()) {
//			throw new RuntimeException("Seu produto não existe, faça um post ao invés de put!");
//		}
//		modificado = repo.save(modificado);
//		return modificado.getId();
//	}	

//	@PutMapping("/{id}")
//	public ResponseEntity<String> put(@RequestBody Produto modificado, @PathVariable("id") String id) {
//		if (!modificado.getId().equals(id)) {
//			//throw new RuntimeException("Para atualizar um produto, os IDs do request devem ser iguais!");
//			return ResponseEntity.badRequest().build();
//		}
//		if (!repo.findById(id).isPresent()) {
//			//throw new RuntimeException("Seu produto não existe, faça um post ao invés de put!");
//			return ResponseEntity.notFound().build();
//		}
//		modificado = repo.save(modificado);
//		return ResponseEntity.ok(modificado.getId());
//	}	

	
	@PutMapping("/{id}")
	public String put(@RequestBody Produto modificado, @PathVariable("id") String id) {
		if (!modificado.getId().equals(id)) {
			throw new BadRequestException("Para atualizar um produto, os IDs do request devem ser iguais!");
		}
		if (!repo.findById(id).isPresent()) {
			throw new NotFoundException("Seu produto não existe, faça um post ao invés de put!");
		}
		modificado = repo.save(modificado);
		return modificado.getId();
	}	
	
}
