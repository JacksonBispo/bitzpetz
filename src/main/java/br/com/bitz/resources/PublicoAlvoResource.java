package br.com.bitz.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.bitz.DTO.ProdutoDTO;
import br.com.bitz.domain.Produto;
import br.com.bitz.services.ProdutoService;

@RestController
@RequestMapping(value = "/publico")
public class PublicoAlvoResource {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value = "/publico", method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> getProducts(@RequestParam(value = "name", defaultValue = "") String name) {
		List<Produto> products = produtoService.findByCategory(name);
		return ResponseEntity.ok().body(products);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> getAllProducts() {
		List<Produto> products = produtoService.findAll();
		return ResponseEntity.ok().body(products);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findByid(@PathVariable Long id ) throws Exception {
		
		Produto produto = produtoService.findById(id);
			return ResponseEntity.ok().body(produto);
		
		
	}
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ProdutoDTO produtoDTO,@PathVariable Long id) throws Exception {
		
			Produto p = produtoService.fromDTO(produtoDTO);
			p.setId(id);
			p = produtoService.update(p);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{/id}").buildAndExpand(p.getId()).toUri();
			return ResponseEntity.created(uri).build();
		
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ProdutoDTO produtoDTO) {
		Produto p = produtoService.fromDTO(produtoDTO);
		p = produtoService.saveProduto(p);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{/id}").buildAndExpand(p.getId()).toUri();
				return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception{
		produtoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
