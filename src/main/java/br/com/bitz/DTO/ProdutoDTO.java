package br.com.bitz.DTO;

import java.math.BigDecimal;

public class ProdutoDTO {

	private Long id;
	
	private String name;
	
	private BigDecimal price;
	
	private String ean;
	
	private String fabricaco;
	
	private Long idPublicoAlvo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getFabricaco() {
		return fabricaco;
	}

	public void setFabricaco(String fabricaco) {
		this.fabricaco = fabricaco;
	}

	public Long getIdPublicoAlvo() {
		return idPublicoAlvo;
	}

	public void setIdPublicoAlvo(Long idPublicoAlvo) {
		this.idPublicoAlvo = idPublicoAlvo;
	}
	
	
}
