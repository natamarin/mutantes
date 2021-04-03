package com.natamarin.mutants.dto;

import java.io.Serializable;

public class ConsultaEstadisticasOutDTO implements Serializable {

	/**
	 * Atributo de seralizacion
	 */
	private static final long serialVersionUID = 1L;
	
	private String estado;
	
	private int count_mutant_dna;
		
	private int count_human_dna;
	
	private Long ratio;
	
	
	public int getCount_human_dna() {
		return count_human_dna;
	}

	public void setCount_human_dna(int count_human_dna) {
		this.count_human_dna = count_human_dna;
	}

	public int getCount_mutant_dna() {
		return count_mutant_dna;
	}

	public void setCount_mutant_dna(int count_mutant_dna) {
		this.count_mutant_dna = count_mutant_dna;
	}

	public Long getRatio() {
		return ratio;
	}

	public void setRatio(Long ratio) {
		this.ratio = ratio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
