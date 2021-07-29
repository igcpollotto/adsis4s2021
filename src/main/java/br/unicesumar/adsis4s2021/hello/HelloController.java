package br.unicesumar.adsis4s2021.hello;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
	
	//Protocolo HTTP define alguns "verbos", tais como:
	// get: para recuperar um recurso
	// post: para criar um recurso
	// put: para atualizar um recurso
	// delete: para excluir um recurso
	

	@GetMapping("/")
	public String sayHello() {
		return "Hello :D";
	}
	
	@GetMapping("/time")
	public String currentTime() {
		return "Data e hora atual: " + new Date().toLocaleString();
	}
}




