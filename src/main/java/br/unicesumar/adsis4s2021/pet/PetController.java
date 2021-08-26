package br.unicesumar.adsis4s2021.pet;

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

@RestController
@RequestMapping("/pets")
public class PetController {
	@Autowired
	private PetRepository repo;

	
	@DeleteMapping("/{id}")
	public void deletePeloId(@PathVariable("id") String id) {
		repo.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Pet getPeloId(@PathVariable("id") String id) {
		return repo.findById(id).get();
	}

	
	@GetMapping
	public List<Pet> getAll() {
		return repo.findAll();
	}
	
	@PostMapping
	public String post(@RequestBody Pet novo) {
		if (repo.findById(novo.getId()).isPresent()) {
			throw new RuntimeException("Seu pet já existe, faça um put ao invés de post!");
		}
		novo = repo.save(novo);
		return novo.getId();
	}
	
	@PutMapping("/{id}")
	public String put(@RequestBody Pet modificado, @PathVariable("id") String id) {
		if (!modificado.getId().equals(id)) {
			throw new RuntimeException("Para atualizar um pet, os IDs do request devem ser iguais!");
		}
		if (!repo.findById(id).isPresent()) {
			throw new RuntimeException("Seu pet não existe, faça um post ao invés de put!");
		}
		modificado = repo.save(modificado);
		return modificado.getId();
	}	

}
