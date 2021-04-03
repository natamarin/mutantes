package com.natamarin.mutants.dto;

import java.io.Serializable;

public class ConsultaEstadisticasOutDTO implements Serializable {

	/**
	 * Atributo de seralizacion
	 */
	private static final long serialVersionUID = 1L;
		
	private Long count_human_dna;
	
	private Long count_mutant_dna;
	
	private Long ratio;
	
	pri
		

	
	public Long getCount_human_dna() {
		return count_human_dna;
	}

	public void setCount_human_dna(Long count_human_dna) {
		this.count_human_dna = count_human_dna;
	}

	public Long getCount_mutant_dna() {
		return count_mutant_dna;
	}

	public void setCount_mutant_dna(Long count_mutant_dna) {
		this.count_mutant_dna = count_mutant_dna;
	}

	public Long getRatio() {
		return ratio;
	}

	public void setRatio(Long ratio) {
		this.ratio = ratio;
	}
	
}
