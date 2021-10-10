package br.unicesumar.adsis4s2021.injeção_de_dependências;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SistemaSolar {
	@Autowired
	private Sol sol;
	
	public Sol getSol() {
		return sol;
	}

}
