package com.natamarin.mutants.dto;

import java.io.Serializable;

public class ConsultaMutantesOutDTO implements Serializable {

	/**
	 * Atributo de seralizacion
	 */
	private static final long serialVersionUID = 1L;
		
	/**
	 * Atributo que determina el codigo de status del servicio  
	 */
	private String estado;

	
	/**
	 * Constructor de la clase.
	 */
	public ConsultaMutantesOutDTO() {
		//constructor de la clase
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}

}
