package br.unicesumar.adsis4s2021.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BaseController<ENTITY extends BaseEntity, REPO extends JpaRepository<ENTITY, String>> {
	@Autowired
	private REPO repo;

	@DeleteMapping("/{id}")
	public void deletePeloId(@PathVariable("id") String id) {
		repo.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public ENTITY getPeloId(@PathVariable("id") String id) {
		return repo.findById(id).get();
	}
	
	@GetMapping
	public List<ENTITY> getAll() {
		return repo.findAll();
	}
	
	@PostMapping
	public String post(@RequestBody ENTITY novo) {
		if (novo.getId() != null && repo.findById(novo.getId()).isPresent()) {
			throw new RuntimeException("Seu registro já existe, faça um put ao invés de post!");
		}
		novo = repo.save(novo);
		return novo.getId();
	}
	
	@PutMapping("/{id}")
	public String put(@RequestBody ENTITY modificado, @PathVariable("id") String id) {
		if (!modificado.getId().equals(id)) {
			throw new RuntimeException("Para atualizar um registro, os Strings do request devem ser iguais!");
		}
		if (!repo.findById(id).isPresent()) {
			throw new RuntimeException("Seu registro não existe, faça um post ao invés de put!");
		}
		modificado = repo.save(modificado);
		return modificado.getId();
	}	

}
