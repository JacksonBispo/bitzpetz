package br.com.bitz.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bitz.domain.Product;

@Repository
public interface ProductRepositry extends JpaRepository<Product, Long> {
	
	@Query(value = "SELECT p.* FROM PRODUCT P INNER JOIN CATEGORY C ON C.ID = P.CATEGORY_ID   WHERE P.NAME LIKE %?%1" , nativeQuery = true)
	List<Product> findProductsByCategory(String name);
	

}
