package com.natamarin.mutants.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.natamarin.mutants.dto.ConsultaEstadisticasOutDTO;
import com.natamarin.mutants.repository.MutantRepository;

@Service
public class StatsService {
	
	@Autowired
	MutantRepository mutantRepository;
			
	@GetMapping("/stats")
	public ConsultaEstadisticasOutDTO stats() {
		
		ConsultaEstadisticasOutDTO consultaEstadisticasOutDTO = new ConsultaEstadisticasOutDTO();
				
		// Se consultan los ADN verificados
		int contAdnHumanos = mutantRepository.countByEsMutante(Boolean.FALSE);
		int contAdnMutantes = mutantRepository.countByEsMutante(Boolean.TRUE);		
		Long ratio = 0L;
				
		consultaEstadisticasOutDTO.setEstado("200");
		consultaEstadisticasOutDTO.setCount_human_dna(contAdnHumanos);
		consultaEstadisticasOutDTO.setCount_mutant_dna(contAdnMutantes);
		
		// Si alguno es 0, retorna 0
		if (contAdnHumanos == 0 || contAdnMutantes == 0) {
			ratio = 0L;	
			consultaEstadisticasOutDTO.setRatio(ratio);
			return consultaEstadisticasOutDTO;
		}
		
		// Se calcula el ratio
		ratio = Long.valueOf(contAdnMutantes) / Long.valueOf(contAdnHumanos);		
		consultaEstadisticasOutDTO.setRatio(ratio);		
		return consultaEstadisticasOutDTO;
	}
}
