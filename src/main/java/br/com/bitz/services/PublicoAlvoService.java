package br.com.bitz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bitz.domain.PublicoAlvo;
import br.com.bitz.repositories.PublicoAlvoRepository;


@Service
public class PublicoAlvoService {

	@Autowired
	private PublicoAlvoRepository publicoAlvoRepository;
	
	public void savePublicoAlvo(PublicoAlvo PublicoAlvo) {
		publicoAlvoRepository.save(PublicoAlvo);
	}
	
	
	
	@Transactional(readOnly = true)
	public List<PublicoAlvo> findAll(){
		List<PublicoAlvo> PublicoAlvos = publicoAlvoRepository.findAll();
		return PublicoAlvos;
	}
	
	
	public PublicoAlvo fromDTO(PublicoAlvo objDTO) {
		PublicoAlvo publicoAlvo = new PublicoAlvo();
		publicoAlvo.setId(objDTO.getId());
		publicoAlvo.setName(objDTO.getName());
		return publicoAlvo;
	}



	public PublicoAlvo findById(Long id) throws Exception{
		Optional<PublicoAlvo> publicoAlvo = publicoAlvoRepository.findById(id);
		return  publicoAlvo.orElseThrow(()->
				new Exception("objeto nao encontrado ID: "+ id + ",tipo: "+PublicoAlvo.class));
	}
	
	public void update (PublicoAlvo publicoAlvo) throws Exception {
		PublicoAlvo newObj = findById(publicoAlvo.getId());
		newObj.setName(publicoAlvo.getName());
		publicoAlvoRepository.save(newObj);
	}
	
	public void delete(Long id) {
		publicoAlvoRepository.deleteById(id);
	}
}
