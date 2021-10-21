package br.unicesumar.adsis4s2021.qualquer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unicesumar.adsis4s2021.pedido.PedidoService;
import br.unicesumar.adsis4s2021.pedido.dto.TotalVendidoDoProdutoDTO;

@Component
public class Qualquer {
	@Autowired
	private PedidoService service;
	
	
	public void testar() {
		List<TotalVendidoDoProdutoDTO> resultado = service.consultarTotalVendidoPorProdutoDTO();
		System.out.println("Foi.");
	}

}
