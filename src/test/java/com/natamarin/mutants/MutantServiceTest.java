package com.natamarin.mutants;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.natamarin.mutants.dto.ConsultaMutantesInDTO;
import com.natamarin.mutants.dto.ConsultaMutantesOutDTO;
import com.natamarin.mutants.repository.MutantRepository;
import com.natamarin.mutants.services.MutantService;


@ExtendWith(MockitoExtension.class)
public class MutantServiceTest {
	
	@Mock
	MutantRepository mutantRepository;
	
	@InjectMocks
	MutantService mutantService;
		
	/**
	 * Prueba unitaria donde se envía un ADN de mutante
	 * de forma horizontal
	 */
	@Test
	public void mutantTest1() {
		
		String[] adn = {"AAAA", "CCCC"};
		
		ConsultaMutantesInDTO consultaMutantesInDTO = new ConsultaMutantesInDTO();
		consultaMutantesInDTO.setAdn(adn);
		ConsultaMutantesOutDTO consultaMutantesOutDTO = mutantService.mutant(consultaMutantesInDTO);
		
		System.out.println(consultaMutantesOutDTO.getEstado());
		
		assertEquals("200", consultaMutantesOutDTO.getEstado());		
	}
	
	/**
	 * Prueba unitaria donde se envía un ADN de NO mutante
	 */
	@Test
	public void mutantTest2() {
		
		String[] adn = {"AAAA", "CACT"};
		
		ConsultaMutantesInDTO consultaMutantesInDTO = new ConsultaMutantesInDTO();
		consultaMutantesInDTO.setAdn(adn);
		ConsultaMutantesOutDTO consultaMutantesOutDTO = mutantService.mutant(consultaMutantesInDTO);
		
		System.out.println(consultaMutantesOutDTO.getEstado());
		
		assertEquals("403", consultaMutantesOutDTO.getEstado());
	}
	
	/**
	 * Prueba unitaria donde se envía un ADN no válido
	 */
	@Test
	public void mutantTest3() {
		
		String[] adn = {"AAAA"};
		
		ConsultaMutantesInDTO consultaMutantesInDTO = new ConsultaMutantesInDTO();
		consultaMutantesInDTO.setAdn(adn);
		ConsultaMutantesOutDTO consultaMutantesOutDTO = mutantService.mutant(consultaMutantesInDTO);
		
		System.out.println(consultaMutantesOutDTO.getEstado());
		
		assertEquals("400", consultaMutantesOutDTO.getEstado());
	}
	
	/**
	 * Prueba unitaria donde se envía un ADN no válido
	 */
	@Test
	public void mutantTest4() {
		
		String[] adn = {"AAAA", "CC"};
		
		ConsultaMutantesInDTO consultaMutantesInDTO = new ConsultaMutantesInDTO();
		consultaMutantesInDTO.setAdn(adn);
		ConsultaMutantesOutDTO consultaMutantesOutDTO = mutantService.mutant(consultaMutantesInDTO);
		
		System.out.println(consultaMutantesOutDTO.getEstado());
		
		assertEquals("400", consultaMutantesOutDTO.getEstado());
	}
	
	/**
	 * Prueba unitaria donde se envía un ADN de mutante
	 * de forma vertical y diagonal izquierda
	 */
	@Test
	public void mutantTest5() {
		
		String[] adn = {"TGCTA", "TCGAT", "TTAGA", "TAAAA"};
		
		ConsultaMutantesInDTO consultaMutantesInDTO = new ConsultaMutantesInDTO();
		consultaMutantesInDTO.setAdn(adn);
		ConsultaMutantesOutDTO consultaMutantesOutDTO = mutantService.mutant(consultaMutantesInDTO);
		
		System.out.println(consultaMutantesOutDTO.getEstado());
		
		assertEquals("200", consultaMutantesOutDTO.getEstado());		
	}
	
	/**
	 * Prueba unitaria donde se envía un ADN de mutante
	 * de forma vertical y diagonal derecha
	 */
	@Test
	public void mutantTest6() {
		
		String[] adn = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
		
		ConsultaMutantesInDTO consultaMutantesInDTO = new ConsultaMutantesInDTO();
		consultaMutantesInDTO.setAdn(adn);
		ConsultaMutantesOutDTO consultaMutantesOutDTO = mutantService.mutant(consultaMutantesInDTO);
		
		System.out.println(consultaMutantesOutDTO.getEstado());
		
		assertEquals("200", consultaMutantesOutDTO.getEstado());		
	}
	
	/**
	 * Prueba unitaria donde se envía un ADN con letras no permitidas
	 */
	@Test
	public void mutantTest7() {
		
		String[] adn = {"ASAI", "CCCM"};
		
		ConsultaMutantesInDTO consultaMutantesInDTO = new ConsultaMutantesInDTO();
		consultaMutantesInDTO.setAdn(adn);
		ConsultaMutantesOutDTO consultaMutantesOutDTO = mutantService.mutant(consultaMutantesInDTO);
		
		System.out.println(consultaMutantesOutDTO.getEstado());
		
		assertEquals("400", consultaMutantesOutDTO.getEstado());
	}
}
