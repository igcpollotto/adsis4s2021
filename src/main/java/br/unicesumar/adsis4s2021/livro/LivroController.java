package br.unicesumar.adsis4s2021.livro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@GetMapping
	public void getAll() {
		
	}

}
