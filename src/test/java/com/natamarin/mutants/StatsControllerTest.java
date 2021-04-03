package com.natamarin.mutants;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.natamarin.mutants.controller.MutantController;
import com.natamarin.mutants.services.StatsService;


@WebMvcTest(MutantController.class)
public class StatsControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean	
	private StatsService statsService;
	
	@Test
	public void statsControllerTest1() {
		
		statsService.stats();
		
		
	}
		

}
