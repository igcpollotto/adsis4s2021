package br.unicesumar.adsis4s2021;

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
class ApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper jacksonObjectMapper;
	
	@MockBean
	private ProdutoRepository produtoRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void getAllProdutos() throws Exception {
		List<Produto> retorno = Arrays.asList(new Produto("1","1",1));		
		Mockito.when(produtoRepository.findAll()).thenReturn(retorno); 
		
		mockMvc.perform(get("/produtos")).andExpect(status().is2xxSuccessful());
		String content = mockMvc.perform(get("/produtos")).andReturn().getResponse().getContentAsString();
		System.out.println(content);
		Produto[] produtos = jacksonObjectMapper.readValue(content, Produto[].class);
		System.out.println(produtos.length);
		/*
		CollectionType typeReference =
    		TypeFactory.defaultInstance().constructCollectionType(List.class, Dto.class);
			List<Dto> resultDto = objectMapper.readValue(content, typeReference);
		 */
		
	}

}
