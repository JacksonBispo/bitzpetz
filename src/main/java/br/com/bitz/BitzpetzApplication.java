package br.com.bitz;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.bitz.domain.Category;
import br.com.bitz.domain.Product;
import br.com.bitz.repositories.CategoryRepositry;
import br.com.bitz.repositories.ProductRepositry;

@SpringBootApplication 
public class BitzpetzApplication implements  CommandLineRunner{
	
	@Autowired
	private ProductRepositry productRepositry;
	@Autowired
	private CategoryRepositry categoriaRepositry;

	public static void main(String[] args) {
		SpringApplication.run(BitzpetzApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {

		Product p = new Product();
		p.setName("Racao para gatos");
		p.setPrice(new BigDecimal(45.99));
		p.setEan("037867");
		
		Category c = new Category();
		c.setName("felinos");
		c.setProducts(Arrays.asList(p));
		categoriaRepositry.saveAll(Arrays.asList(c));
		p.setCategory(c);
		productRepositry.saveAll(Arrays.asList(p));
	}
}
