package com.natamarin.mutants;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

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
	
	@Autowired
	TestEntityManager entityManager;   
		
	/**
	 * Prueba unitaria donde se envía un ADN de mutante
	 * de forma horizontal
	 */
	@Test
	public void statsTest1() {
		
	
		AdnVerificado anAdnVerificado = new AdnVerificado();
		anAdnVerificado.setId(1L);
		anAdnVerificado.setAdn("hola");
		anAdnVerificado.setEsMutante(Boolean.TRUE);
				
		mutantRepository.save(anAdnVerificado);
				
		
				
		ConsultaEstadisticasOutDTO consultaEstadisticasOutDTO = statsService.stats();
		
		System.out.println(consultaEstadisticasOutDTO.getCount_human_dna());
		System.out.println(consultaEstadisticasOutDTO.getCount_mutant_dna());
			
	}
	
}