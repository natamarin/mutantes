package com.natamarin.mutants.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdnVerificado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length=1000)
	private String adn;
	
	private Boolean esMutante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdn() {
		return adn;
	}

	public void setAdn(String adn) {
		this.adn = adn;
	}

	public Boolean getEsMutante() {
		return esMutante;
	}

	public void setEsMutante(Boolean esMutante) {
		this.esMutante = esMutante;
	}
	
}
