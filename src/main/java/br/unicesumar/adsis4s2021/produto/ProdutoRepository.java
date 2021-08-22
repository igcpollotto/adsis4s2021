package br.unicesumar.adsis4s2021.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<Produto, String>{
	
	@Query("select p from Produto p where p.preco >= :preco")
	List<Produto> recuperarPreçoMaiorQue(double preco);

	@Query(value =  "select p.nome, p.id, p.preco from produto p where p.preco >= :preco", nativeQuery = true)
	List<Produto> recuperarPreçoMaiorQueViaSQL(double preco);
}
