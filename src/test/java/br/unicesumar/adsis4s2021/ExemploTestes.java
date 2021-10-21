package br.unicesumar.adsis4s2021;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.unicesumar.adsis4s2021.produto.Produto;
import br.unicesumar.adsis4s2021.produto.ProdutoRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class ExemploTestes {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper jacksonObjectMapper;
	
	@MockBean
	private ProdutoRepository produtoRepository;
	


	@Test
	void testarUmMaisUm() {
		assertEquals(2, 1+1);
	}

	@Test
	void testarDoisMaisDois() {
		assertEquals(4, 2+2);
	}
	@Test
	void getAllProdutosRetornaAlgumProduto() throws Exception {
		List<Produto> retorno = Arrays.asList(
				new Produto("1","1",1), 
				new Produto("2","2",2), 
				new Produto("3","3",3));		
		Mockito
			.when(produtoRepository.findAll())
			.thenReturn(retorno); 
		
		String jsonDosProdutosRetornados = mockMvc
				.perform(get("/produtos"))
				.andReturn()
				.getResponse()
				.getContentAsString();
		
		Produto[] produtos = jacksonObjectMapper.readValue(jsonDosProdutosRetornados, Produto[].class);
		
		assertEquals(3, produtos.length);

	}
	
	@Test
	void getAllProdutosRetornaStatus200() throws Exception {
		mockMvc
			.perform(get("/produtos"))
			.andExpect(status().is(200));		
	}
	@Test
	void getAllLivrosRetornaStatus200() throws Exception {
		mockMvc
			.perform(get("/livros"))
			.andExpect(status().is(200));		
	}
	
}

