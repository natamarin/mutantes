package com.natamarin.mutants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.natamarin.mutants.dto.ConsultaEstadisticasOutDTO;
import com.natamarin.mutants.entity.AdnVerificado;
import com.natamarin.mutants.repository.MutantRepository;

@Service
public class StatsService {
	
	@Autowired
	MutantRepository mutantRepository;
			
	@GetMapping("/stats")
	public ConsultaEstadisticasOutDTO stats() {
		
		ConsultaEstadisticasOutDTO consultaEstadisticasOutDTO = new ConsultaEstadisticasOutDTO();
		
		List<AdnVerificado> listaAdn = (List<AdnVerificado>) mutantRepository.findAll();
		
		// Se consultan los ADN verificados
		Long ratio = 0L;
		Long contAdnHumanos = 0L;
		Long contAdnMutantes = 0L;
		
		for (AdnVerificado adn : listaAdn) {
			if (adn.getEsMutante()) {
				contAdnHumanos = contAdnHumanos + 1;
			} else {
				contAdnMutantes = contAdnMutantes + 1;
			}
		}
		
		consultaEstadisticasOutDTO.setCount_human_dna(contAdnHumanos);
		consultaEstadisticasOutDTO.setCount_mutant_dna(contAdnMutantes);
		
		// Si alguno es 0, retorna 0
		if (contAdnHumanos == 0 || contAdnMutantes == 0) {
			ratio = 0L;	
			consultaEstadisticasOutDTO.setRatio(ratio);
			return consultaEstadisticasOutDTO;
		}
		
		// Se calcula el ratio
		ratio = contAdnHumanos / contAdnMutantes;		
		consultaEstadisticasOutDTO.setRatio(ratio);
		return consultaEstadisticasOutDTO;
	}
}
