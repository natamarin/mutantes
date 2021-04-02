package com.natamarin.mutants.dto;

import java.io.Serializable;

public class ConsultaMutantesInDTO implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	private String[] adn;
	
	
	public String[] getAdn() {
		return adn;
	}

	public void setAdn(String[] adn) {
		this.adn = adn;
	}

}
