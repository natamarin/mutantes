package com.natamarin.mutants;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.natamarin.mutants.controller.MutantController;
import com.natamarin.mutants.dto.ConsultaMutantesInDTO;
import com.natamarin.mutants.services.MutantService;


@WebMvcTest(MutantController.class)
public class MutantControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean	
	private MutantService mutantService;
	
	@Test
	public void mutantTest1() {
		
		String[] adn = {"AAAA", "CCCC"};
		
		ConsultaMutantesInDTO consultaMutantesInDTO = new ConsultaMutantesInDTO();
		consultaMutantesInDTO.setAdn(adn);
		mutantService.mutant(consultaMutantesInDTO);
		
	}
	
	
	
	

}
