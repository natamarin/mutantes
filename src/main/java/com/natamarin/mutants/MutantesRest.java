package com.natamarin.mutants;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutantesRest {
	
	/*
	 * Servicio encargado de leer un array con la secuencia de ADN
	 */
	@PostMapping("/mutant")
	public String mutant(
			//String[] dna
			) {
		
		// Se valida que las letras ingresadas sean A, T, C, G
		
//		for (int i = 0; i < dna.length; i++){
//			
//		}
		//Se valida que el array tenga como mínimo una sentencia de 4 caracteres
		
		
		
		return "Hola mundo2";
	}

}
