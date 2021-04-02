# Prueba técnica Mercadolibre

![image](https://user-images.githubusercontent.com/81449113/113436385-3f42d500-93aa-11eb-879d-645dd4d6e10a.png)

Identificar si un ADN (array de caracteres) pertenece o no a un mutante. Se sabe que es mutante si se encuentra más de una secuencia de cuatro caracteres A, T, C, G.

## Solución

### Validaciones iniciales:
*	Se valida que el tamaño mínimo del array sea {1,8}, {8,1}, {2,4} o {4,2}
*	Se valida que cada cadena tenga la misma cantidad de caracteres
*	Se valida que los caracteres correspondan a las letras A, T, C, G
NOTA: Si alguna validación falla, finaliza y retorna estado de error. 

Se arma una matriz con el array que contiene el ADN de entrada y se comienza a iterar sus filas y columnas para encontrar coincidencias todas las posiciones: derecha, abajo, diagonal derecha y diagonal izquierda.
La letra posicionada en [i][j] se toma como letra a comparar y se llama a cada método con la dirección a buscar. Si la letra a comparar coincide con la letra de la posición (ejemplo derecha) se llama al mismo método de forma recursiva aumentando una posición para validar si existe otra coincidencia, esto lo hace hasta que encuentra 4 coincidencias. 
Cada método de dirección posee la misma lógica y se va moviendo entre las casillas según la dirección en la que esté buscando.

Si un método de dirección encuentra las 4 coincidencias, las retorna y las almacena en una cadena de String. Cuando la cadena cuente con 8 caracteres, finaliza los ciclos y retorna true pues esto significa que ya encontró un ADN de mutante.

### Ejemplo:
![image](https://user-images.githubusercontent.com/81449113/113435216-fc7ffd80-93a7-11eb-8a6f-a7d3fb16778e.png)

En esta matriz se puede observar que existen tres secuencias de 4 caracteres en diferentes direcciones: vertical, diagonal izquierdo y horizontal.

Al procesar la matriz, va a encontrar la primera secuencia TTTT en forma vertical, seguido a esto, encontrará la segunda secuencia AAAA en forma diagonal izquierdo. Como ya encontró las dos secuencias de 4 caracteres (es decir ya tiene una cadena de 8 caracteres) termina los ciclos y finaliza el procesamiento.

## Tecnologías utilizadas
* Heroku
* Java 1.8
* Spring boot
* Maven
* PostgreSQL

## Servicios Rest

*	/mutant<br>
Servicio POST que recibe un Json con el siguiente formato

{
 "adn": ["TGCTA", "TCGAT", "TTAGA", "TAAAA"]
}

*	/stats<br>
Servicio GET que retorna un Json con el siguiente formato
{
    "count_mutant_dna":40, 
    "count_human_dna":100,
    "ratio":0.4
}

### Códigos de respuesta

* 200 - Ok
* 403 - Forbidden
*	400 - Bad request

## Instrucciones de ejecución

Se puede acceder con las URL de cada servicio mediante SoapUI, teniendo en cuenta el tipo de solicitud y formato Json descritos anteriormente.
```
http://mutants123.herokuapp.com/mutant
http://mutants123.herokuapp.com/stats
```

Si se requiere ver la Base de datos, en un cliente de PostgreSQL poner los siguientes datos de conexión:
```
Host: ec2-54-205-183-19.compute-1.amazonaws.com
Database: d98eokp3ms4fn0
User: nwiimfqxlzybjo
Pass: c35ad2177c07b8d854db8ca71a9c999b42d5ee72f1d2a2ec4fa99ac77864cdf4
Port: 5432
```





