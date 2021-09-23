package br.unicesumar.adsis4s2021.produto_transiente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos-transientes")
public class ProdutoTransienteController {
	private List<ProdutoTransiente> produtos = new ArrayList<>();
	
	public ProdutoTransienteController() {
		produtos.add(new ProdutoTransiente("1", "Omo Progress", 29.95));
		produtos.add(new ProdutoTransiente("2", "Mamão Formosa", 4.95));
		produtos.add(new ProdutoTransiente("3", "Cerveja Ipa Opa Epa", 9.75));
		
		Map<String, Object> omoProgressComoMapa = new HashMap<>();
		omoProgressComoMapa.put("id", "1");
		omoProgressComoMapa.put("nome", "Omo Progress");
		omoProgressComoMapa.put("preco", 29.95);
		
		omoProgressComoMapa.put("id", "100");
		for (Entry<String, Object> e : omoProgressComoMapa.entrySet()) {
			System.out.println(e.getKey() + " ==> "  + e.getValue());
		}
		
		
		
	}
	@PostMapping
	public void postProduto(@RequestBody Map<String, String> novoProduto) {
		System.out.println(">>>> post!");
		for (Entry<String, String> e : novoProduto.entrySet()) {
			System.out.println(e.getKey() + " ==> "  + e.getValue());
		}
		double preco = Double.parseDouble(novoProduto.get("preco")) * 2;
		System.out.println(preco);
		//System.out.println(novoProduto.getPreco() * 2);
		produtos.add(new ProdutoTransiente(novoProduto.get("id"), novoProduto.get("nome"), Double.parseDouble(novoProduto.get("preco"))));
	}
	
//	@PostMapping
//	public void postProduto(@RequestBody ProdutoTransiente novoProduto) {
//		produtos.add(novoProduto);
//	}
	
	@GetMapping
	public List<ProdutoTransiente> getProdutos() {
		return this.produtos;
	}
	@GetMapping("/{id}")
	public ProdutoTransiente getProdutoPeloId(@PathVariable("id") String id) {
		for (ProdutoTransiente p : produtos) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}
	@DeleteMapping("/{id}")
	public void deleteProdutoPeloId(@PathVariable("id") String id) {
		ProdutoTransiente paraRemover = null;
		for (ProdutoTransiente p : produtos) {
			if (p.getId().equals(id)) {
				paraRemover = p;
			}
		}
		if (paraRemover != null) {
			produtos.remove(paraRemover);
		}
	}
	

}



