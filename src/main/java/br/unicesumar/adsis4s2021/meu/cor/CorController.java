package br.unicesumar.adsis4s2021.meu.cor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Ctrl + space para importar 
@RestController
@RequestMapping("/cores")
//quando o servidor subir na porta 9095
public class CorController {
	private List<Cor> cores = new ArrayList<>();
	
	
	public CorController() {	//nome , sigla
		this.cores.add(new Cor("Preto", "BLK"));//esta criando uma instancia de cor, e essa instancia vai ser adicionada a lista de cores
		//a cor é criada e depois é adicionada a lista de cor
		this.cores.add(new Cor("azul", "bl"));
		this.cores.add(new Cor("verde", "sei la"));
		/*a lista de cor tem 3 cores ate aqui, que e os dados que vera
		 * no geter do controler*/
	}
	
	@GetMapping
	public List<Cor> getCores(){//getCores pode ser qualquer nome!
		return this.cores;
		/*o endereço fica esposto na IPI, vai ser chamado
		 * via rede, o servidor vai interceptar a chamada get
		 * tem um getCor, e leva o resultado em objeto JAVA!
		 * a web nao conhece isso, ela conhece texto binario,
		 * o servidor transforma em linguagem compreencivel 
		 * geralmente é XML ou JSON, por padrao o spring vai gerar
		 * essa resposta e vai chamar um JAQSON
		 * biblioteca que representa transformar em JSON
		 * entao retorna uma LISTA JAVA porem a web recebera um Json*/
	}
	
	//perguntar por que VOID ?
	//o dado da cor nova vem do corpo do RequestBody
	@PostMapping
	public void postCor(@RequestBody Cor nova) {
		this.cores.add(nova);
	}
}
