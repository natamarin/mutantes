package com.natamarin.mutants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.natamarin.mutants.dto.ConsultaMutantesInDTO;
import com.natamarin.mutants.dto.ConsultaMutantesOutDTO;
import com.natamarin.mutants.services.MutantService;

@RestController
@RequestMapping(value = "/mutant", method = RequestMethod.POST)
public class MutantController {
	
	@Autowired
	private MutantService mutantService;
		 
	@GetMapping
	public ConsultaMutantesOutDTO esMutante(@RequestBody ConsultaMutantesInDTO consultaMutantesInDTO) {
		
		return mutantService.mutant(consultaMutantesInDTO);
	}
	
}
