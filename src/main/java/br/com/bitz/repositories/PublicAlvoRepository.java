package br.com.bitz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bitz.domain.PublicoAlvo;

@Repository
public interface PublicAlvoRepository extends JpaRepository<PublicoAlvo, Long> {
	
	

}
