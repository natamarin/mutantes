package com.natamarin.mutants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.natamarin.mutants.dto.ConsultaEstadisticasOutDTO;
import com.natamarin.mutants.services.StatsService;

@RestController
@RequestMapping(value = "/stats", method = RequestMethod.GET)
public class StatsController {
	
	@Autowired
	private StatsService statsService;
	
	@GetMapping
	public ConsultaEstadisticasOutDTO stats() {
		
		return statsService.stats();
	}	
}
