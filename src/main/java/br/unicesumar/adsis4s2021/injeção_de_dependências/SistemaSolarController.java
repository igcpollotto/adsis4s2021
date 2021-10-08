package br.unicesumar.adsis4s2021.injeção_de_dependências;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sistema_solar")
public class SistemaSolarController {
	//private SistemaSolar sistemaSolar = new SistemaSolar();
	@Autowired
	private SistemaSolar sistemaSolar;
	
	@GetMapping
	public String get() {
		System.out.println("  sol do sistema solar ====> " + sistemaSolar.getSol());
		return "Foi";
	}

}

