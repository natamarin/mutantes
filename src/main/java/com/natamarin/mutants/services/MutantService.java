package com.natamarin.mutants.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.natamarin.mutants.dto.ConsultaMutantesInDTO;
import com.natamarin.mutants.dto.ConsultaMutantesOutDTO;
import com.natamarin.mutants.entity.AdnVerificado;
import com.natamarin.mutants.repository.MutantRepository;

@Service
public class MutantService {
	
	@Autowired
	MutantRepository mutantRepository;
	
	private static final ArrayList<Character> ADN_LETRAS = new ArrayList<>(Arrays.asList('A', 'T', 'C', 'G'));
		
	@PostMapping("/mutant")
	public ResponseEntity mutant(ConsultaMutantesInDTO consultaMutantesInDTO) {
		
		ConsultaMutantesOutDTO consultaMutantesOutDTO = new ConsultaMutantesOutDTO();
		
		int n, m;
		char matriz [][];
		
		// Se obtiene el array de la entrada
		String[] adn = consultaMutantesInDTO.getAdn();
		
		// Se crea una matriz a partir del array
		// la cantidad de filas es el tamaño del array
		n = adn.length;
		
		// Se toma la primera cadena que llegue
		// a partir de la cantidad de letras que tenga 
		// se toma la cantidad de columnas
		String primerElemento = adn[0];
		m = primerElemento.length();
		
		// Se asigna el tamaño de la matriz
		matriz = new char[n][m];
				
		// Se valida que el tamaño de la matriz sea correcto
		if (!validarTamanioMatriz(n, m)) {
			// retorna bad request Codigo 400
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
				
		// Se reccore el array de adn
		for (int i = 0; i < n; i++) {			
			
			// Cada cadena se convierte en lista de caracteres
			char[] caracteresFila = adn[i].toCharArray();
							
			for (int j = 0; j < m; j++) {
				// Se hacen las validaciones sobre la matriz y el caracter procesado
				if (!validarMatriz(primerElemento.length(), caracteresFila.length, caracteresFila[j])) {
					// retorna bad request Codigo 400
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
				}
				
				// Se arma la matriz con los ADN que llegan en el array
				matriz[i][j] = caracteresFila[j];
			}			
		}
				
		// Se buscan las coincidencias en todas las direcciones
		Boolean isMutant = encontrarCoincidencias(n, m, matriz);
		
		// Si el ADN no es mutante
		if (!isMutant) {
			// Se guarda el ADN encontrado
			guardarAdn(isMutant, adn.toString());
			
			// retorna forbidden Codigo 403
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
		}
		
		// Se guarda el ADN encontrado
		guardarAdn(isMutant, adn.toString());
		
		// retorna exitoso Codigo 200
		return ResponseEntity.ok(null);
	}
	
	/**
	 * Método encargado de encontrar las coincidencias
	 * 
	 * @param n, filas
	 * @param m, columnas
	 * @param matriz, matriz con todas las letras
	 * @return true si el ADN es mutante
	 *         false si el ADN no es mutante
	 * 
	 */
	private Boolean encontrarCoincidencias (int n, int m, char matriz [][]) {
		
		Boolean isMutant = Boolean.FALSE;
		StringBuilder adnFinal = new StringBuilder();
		boolean finalizarCiclos = false;
		
		for (int i = 0; i < n && !finalizarCiclos; i++) {		
			for (int j = 0; j < m; j++) {
				
				StringBuilder adnDer = new StringBuilder();
				StringBuilder adnAbajo = new StringBuilder();
				StringBuilder adnDiagDer = new StringBuilder();
				StringBuilder adnDiagIzq = new StringBuilder();				
				
				// Se obtiene el caracter de la posición actual				
				char c = matriz [i][j];
				
				// Se compara hacía la derecha
				adnDer.append(c);
				compararPosicionDerecha(matriz, i, j, n, m, c, adnDer);				
				if (adnDer.length() >= 4) {
					adnFinal.append(adnDer); 
				} 
				
				// Se compara hacía abajo
				adnAbajo.append(c);
				compararPosicionAbajo(matriz, i, j, n, m, c, adnAbajo);
				if (adnAbajo.length() >= 4) {
					adnFinal.append(adnAbajo);					
				} 
				
				// Se compara diagonal a la derecha
				adnDiagDer.append(c);
				compararPosicionDiagDerecha(matriz, i, j, n, m, c, adnDiagDer);
				if (adnDiagDer.length() >= 4) {
					adnFinal.append(adnDiagDer);					
				} 
				
				// Se compara diagonal a la izquierda
				adnDiagIzq.append(c);
				compararPosicionDiagIzquierda(matriz, i, j, n, m, c, adnDiagIzq);
				if (adnDiagIzq.length() >= 4) {
					adnFinal.append(adnDiagIzq);					
				} 
	
				// Cuando la cadena es de 8 caracteres
				// se terminan los ciclos porque significa
				// que ya encontró dos cadenas de ADN de mutantes
				if (adnFinal.length() == 8) {
					finalizarCiclos = true;
					isMutant = Boolean.TRUE;
					break;	
				}				
			}
		}			
		
		return isMutant;
	}	
	
	/**
	 * Método encargado de validar el tamaño de la matriz:
	 * Mínimo debe ser de 1x8, 8x1, 2x4 o 4x2 para obtener las dos secuencias de 4 letras
	 * 
	 * @param n, filas
	 * @param m, columnas
	 * 
	 */
	private Boolean validarTamanioMatriz(int n, int m) {
		
		if (n == 1 && m < 8) {
			return Boolean.FALSE;
		}
		
		if (m == 1 && n < 8) {
			return Boolean.FALSE;
		}
		
		if (m < 4 && n < 2) {
			return Boolean.FALSE;
		}
		
		if (n < 4 && m < 2) {
			return Boolean.FALSE;
		}
				
		
		return Boolean.TRUE;
	}	
	
	/**
	 * Método encargado de realizar las siguientes validaciones sobre la matriz
	 * 1. Cada cadena debe tener la misma cantidad de caracteres
	 * 2. Las letras permitidas son A, T, C, G
	 * 
	 * @param cantidadLetrasInicial, cantidad de letras que tiene la primera cadena
	 * @param cantidadLetras, cantidad de letras que tiene la cadena
	 * @param letra, caracter
	 * 
	 */
	private Boolean validarMatriz(int cantidadLetrasInicial, int cantidadLetras, 
			char letra) {
		
		if (cantidadLetrasInicial != cantidadLetras) {
			return Boolean.FALSE;
		}
		
		if (!ADN_LETRAS.contains(letra)) {
			return Boolean.FALSE;
		}
		
		return Boolean.TRUE;
	}
	
	/**
	 * Método encargado de validar si existe una letra que coincida a la derecha
	 * 
	 * @param matriz, matriz	 
	 * @param i, fila
	 * @param j, columna
	 * @param n, cantidad de filas
	 * @param m, cantidad de columnas
	 * @param letraComparar, caracter
	 * @param adnDerecha, cadena donde se va agregando la letra que coincide
	 * 
	 */
	private void compararPosicionDerecha(char matriz [][], 
			int i, int j, int n, int m, char letraComparar, StringBuilder adnDerecha) {		
		
		if (j+1 < m) {		
			char c = matriz [i][j+1];
			if (letraComparar == c) {
				adnDerecha.append(letraComparar);
				compararPosicionDerecha(matriz, i, j+1, n, m, letraComparar, adnDerecha);				
			}			
		}	
	}
	
	/**
	 * Método encargado de validar si existe una letra que coincida hacía abajo
	 * 
	 * @param matriz, matriz	 
	 * @param i, fila
	 * @param j, columna
	 * @param n, cantidad de filas
	 * @param m, cantidad de columnas
	 * @param letraComparar, caracter
	 * @param adnAbajo, cadena donde se va agregando la letra que coincide
	 * 
	 */
	private void compararPosicionAbajo(char matrizAux [][], 
			int i, int j, int n, int m, char letraComparar, StringBuilder adnAbajo) {		
	
		if ((i+1) < n) {
			char c = matrizAux [i+1][j];
			if (letraComparar == c) {
				adnAbajo.append(letraComparar);		
				compararPosicionAbajo(matrizAux, i+1, j, n, m, letraComparar, adnAbajo);		
			}			
		}
	}
	
	/**
	 * Método encargado de validar si existe una letra que coincida diagonal a la derecha
	 * 
	 * @param matriz, matriz	 
	 * @param i, fila
	 * @param j, columna
	 * @param n, cantidad de filas
	 * @param m, cantidad de columnas
	 * @param letraComparar, caracter
	 * @param adnDiagDerecha, cadena donde se va agregando la letra que coincide
	 * 
	 */
	private void compararPosicionDiagDerecha(char matrizAux [][], 
			int i, int j, int n, int m, char letraComparar, StringBuilder adnDiagDerecha) {
		
		if ((i+1) < n && (j+1) < m) {
			char c = matrizAux [i+1][j+1];
			if (letraComparar == c) {
				adnDiagDerecha.append(letraComparar);	
				compararPosicionDiagDerecha(matrizAux, i+1, j+1, n, m, letraComparar, adnDiagDerecha);
			}			
		}			
	}
	
	/**
	 * Método encargado de validar si existe una letra que coincida diagonal a la izquierda
	 * 
	 * @param matriz, matriz	 
	 * @param i, fila
	 * @param j, columna
	 * @param n, cantidad de filas
	 * @param m, cantidad de columnas
	 * @param letraComparar, caracter
	 * @param adnDiagIzq, cadena donde se va agregando la letra que coincide
	 * 
	 */	
	private void compararPosicionDiagIzquierda(char matrizAux [][], 
			int i, int j, int n, int m, char letraComparar, StringBuilder adnDiagIzq) {
		
		if ((i+1) < n && ((j-1) >= 0 &&  (j-1) < m)) {
			char c = matrizAux [i+1][j-1];
			if (letraComparar == c) {
				adnDiagIzq.append(letraComparar);	
				compararPosicionDiagIzquierda(matrizAux, i+1, j-1, n, m, letraComparar, adnDiagIzq);
			}			
		}	
	}
	
	/**
	 * Método encargado guarda en BD el ADN que se procesó
	 * 
	 * @param isMutant 
	 * @param adn
	 * 
	 */	
	private void guardarAdn(Boolean isMutant, String adn) {
		
		System.out.println("ADN guardar: " +adn);
		
		// Se guarda el ADN encontrado
		AdnVerificado adnVerificado = new AdnVerificado();
		adnVerificado.setAdn(adn.toString());
		adnVerificado.setEsMutante(isMutant);
		mutantRepository.save(adnVerificado);
	}
}
