package br.unicesumar.adsis4s2021.injeção_de_dependências;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unicesumar.adsis4s2021.produto.ProdutoRepository;

@Component
public class Sol {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public String toString() {
		return "Sol [dataSource=" + dataSource + "]";
	}
	
	
	

}
