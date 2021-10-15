package br.unicesumar.adsis4s2021;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.unicesumar.adsis4s2021.qualquer.Qualquer;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private Qualquer q;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);	
	}

	@Override
	public void run(String... args) throws Exception {
		//Qualquer q = new Qualquer();
		q.testar();
		
	}

}
