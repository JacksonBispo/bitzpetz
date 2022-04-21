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

import br.com.bitz.domain.PublicoAlvo;
import br.com.bitz.services.PublicoAlvoService;

@RestController
@RequestMapping(value = "/publico")
public class PublicoAlvoResource {

	@Autowired
	private PublicoAlvoService publicoAlvoService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<PublicoAlvo>> getProducts(@RequestParam(value = "name", defaultValue = "") String name) {
		List<PublicoAlvo> products = publicoAlvoService.findAll();
		return ResponseEntity.ok().body(products);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findByid(@PathVariable Long id ) throws Exception {
		
		PublicoAlvo publicoAlvo = publicoAlvoService.findById(id);
			return ResponseEntity.ok().body(publicoAlvo);
		
		
	}
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody PublicoAlvo publicoAlvo,@PathVariable Long id) throws Exception {
		
			publicoAlvo.setId(id);
			publicoAlvoService.update(publicoAlvo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{/id}").buildAndExpand(publicoAlvo.getId()).toUri();
			return ResponseEntity.created(uri).build();
		
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody PublicoAlvo publicoAlvo) {
		publicoAlvoService.savePublicoAlvo(publicoAlvo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{/id}").buildAndExpand(publicoAlvo.getId()).toUri();
				return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception{
		publicoAlvoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
