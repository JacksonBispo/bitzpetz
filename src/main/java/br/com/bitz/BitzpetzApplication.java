package br.com.bitz;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.bitz.domain.Produto;
import br.com.bitz.domain.PublicoAlvo;
import br.com.bitz.repositories.ProdutoRepository;
import br.com.bitz.repositories.PublicoAlvoRepository;

@SpringBootApplication 
public class BitzpetzApplication implements  CommandLineRunner{
	
	@Autowired
	private ProdutoRepository productRepositry;
	@Autowired
	private PublicoAlvoRepository categoriaRepositry;

	public static void main(String[] args) {
		SpringApplication.run(BitzpetzApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
		Produto produto = new Produto();
		produto.setName("Wiskas");
		produto.setPrice(new BigDecimal(39.99));
		produto.setEan("037867");
		produto.setFabricaco(sdf.parse("30/09/2019 10:30"));
		
		Produto produto2 = new Produto();
		produto2.setName("Pedigree");
		produto2.setPrice(new BigDecimal(45.99));
		produto2.setEan("037866");
		produto2.setFabricaco(sdf.parse("30/01/2019 09:30"));
		
		Produto produto3 = new Produto();
		produto3.setName("Alpiste");
		produto3.setPrice(new BigDecimal(2.99));
		produto3.setEan("037830");
		produto3.setFabricaco(sdf.parse("30/01/2019 09:30"));
		PublicoAlvo publicoAlvo = new PublicoAlvo();
		publicoAlvo.setName("Gato");
		
		PublicoAlvo publicoAlvo2 = new PublicoAlvo();
		publicoAlvo2.setName("cachorro");
		
		PublicoAlvo publicoAlvo3 = new PublicoAlvo();
		publicoAlvo3.setName("passaro");
		
		publicoAlvo.setProdutos(Arrays.asList(produto));
		publicoAlvo2.setProdutos(Arrays.asList(produto2));
		publicoAlvo3.setProdutos(Arrays.asList(produto3));
		
		categoriaRepositry.saveAll(Arrays.asList(publicoAlvo,publicoAlvo2,publicoAlvo3));
		
		produto.setPublicoAlvo(publicoAlvo);
		produto2.setPublicoAlvo(publicoAlvo2);
		produto3.setPublicoAlvo(publicoAlvo3);
		productRepositry.saveAll(Arrays.asList(produto,produto2, produto3));
	}
}
