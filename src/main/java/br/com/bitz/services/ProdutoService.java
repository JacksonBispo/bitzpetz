package br.com.bitz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bitz.DTO.ProdutoDTO;
import br.com.bitz.domain.Produto;
import br.com.bitz.domain.PublicoAlvo;
import br.com.bitz.repositories.ProdutoRepository;


@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto saveProduto(Produto produto) {
		
		produtoRepository.save(produto);
		
		return produto;
	}
	
	public Produto findById(Long id) throws Exception{
		Optional<Produto> produto = produtoRepository.findById(id);
		return  produto.orElseThrow(()->
				new Exception("objeto nao encontrado ID: "+ id + ",tipo: "+Produto.class));
	}

	
	public Produto update(Produto obj) throws Exception {
		Produto newObj = findById(obj.getId());
		updateData(newObj, obj);
		return produtoRepository.save(newObj);
	}

	private void updateData(Produto newObj, Produto obj) {
			newObj.setName(obj.getName());
			newObj.setPrice(obj.getPrice());
			newObj.setEan(obj.getEan());
			newObj.setFabricaco(obj.getFabricaco());
			newObj.setPublicoAlvo(obj.getPublicoAlvo());
			
	}

	
	@Transactional(readOnly = true)
	public List<Produto> findByCategory(String name){
		List<Produto> Produtos = produtoRepository.findProductsByCategory(name);
		return Produtos;
	}
	
	@Transactional(readOnly = true)
	public List<Produto> findAll(){
		List<Produto> Produtos = produtoRepository.findAll();
		return Produtos;
	}
	
	public Produto fromDTO(ProdutoDTO produtoDTO) {
		
		PublicoAlvo publico = new PublicoAlvo();
		publico.setId(produtoDTO.getIdPublicoAlvo());
		
		Produto produto = new Produto();
		produto.setId(produto.getId());
		produto.setName(produtoDTO.getName());
		produto.setEan(produtoDTO.getEan());
		produto.setFabricaco(produtoDTO.getFabricaco());
		produto.setPrice(produtoDTO.getPrice());
		publico.getProdutos().add(produto);
		produto.setPublicoAlvo(publico);
		return produto;
	}

	public void delete(Long id) {
		produtoRepository.deleteById(id);
	}
	
}
