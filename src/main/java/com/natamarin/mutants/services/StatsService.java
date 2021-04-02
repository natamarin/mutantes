package com.natamarin.mutants.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class StatsService {
			
	@GetMapping("/stats")
	public void stats() {
		
	}
}
