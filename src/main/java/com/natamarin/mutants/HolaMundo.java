package com.natamarin.mutants;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {
	
	@RequestMapping("/hola")
	public String hola() {
		return "Hola mundo";
	}
}
