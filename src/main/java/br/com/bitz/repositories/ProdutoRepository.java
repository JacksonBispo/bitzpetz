package br.com.bitz.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bitz.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query(value = "SELECT * FROM PRODUTO P INNER JOIN PUBLICO_ALVO C ON C.ID = P.PUBLICO_ID   WHERE C.NAME LIKE %?1" , nativeQuery = true)
	List<Produto> findProductsByCategory(String name);
	

}
