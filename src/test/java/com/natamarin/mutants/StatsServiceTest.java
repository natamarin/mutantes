package com.natamarin.mutants;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.natamarin.mutants.dto.ConsultaEstadisticasOutDTO;
import com.natamarin.mutants.entity.AdnVerificado;
import com.natamarin.mutants.repository.MutantRepository;
import com.natamarin.mutants.services.StatsService;


@ExtendWith(MockitoExtension.class)
public class StatsServiceTest {
		
	@Mock
	MutantRepository mutantRepository;
	
	@InjectMocks
	StatsService statsService;
			
	/**
	 * Prueba unitaria donde se envía un ADN de mutante
	 * de forma horizontal
	 */
	@Test
	public void statsTest1() {
		
	
		AdnVerificado anAdnVerificado = new AdnVerificado();
		anAdnVerificado.setId(100L);
		anAdnVerificado.setAdn("hola");
		anAdnVerificado.setEsMutante(Boolean.TRUE);
				
		mutantRepository.save(anAdnVerificado);
				
		System.out.println(mutantRepository.countByEsMutante(Boolean.TRUE));
		
				
		ConsultaEstadisticasOutDTO consultaEstadisticasOutDTO = statsService.stats();
		
		System.out.println(consultaEstadisticasOutDTO.getCount_human_dna());
		System.out.println(consultaEstadisticasOutDTO.getCount_mutant_dna());
			
	}
	
}