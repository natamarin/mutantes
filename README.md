Prueba técnica Mercadolibre

Identificar si un ADN (array de caracteres) pertenece o no a un mutante. Se sabe que es mutante si se encuentra más de una secuencia de cuatro caracteres A, T, C, G.

Solución

Validaciones iniciales:
•	Se valida que el tamaño mínimo del array sea {1,8}, {8,1}, {2,4} o {4,2}
•	Se valida que cada cadena tenga la misma cantidad de caracteres
•	Se valida que los caracteres correspondan a las letras A, T, C, G
NOTA: Si alguna validación falla, finaliza y retorna estado de error. 

Se arma una matriz con el array que contiene el ADN de entrada y se comienza a iterar sus filas y columnas para encontrar coincidencias todas las posiciones: derecha, abajo, diagonal derecha y diagonal izquierda.
La letra posicionada en [i][j] se toma como letra a comparar y se llama a cada método con la dirección a buscar. Si la letra a comparar coincide con la letra de la posición (ejemplo derecha) se llama al mismo método de forma recursiva aumentando una posición para validar si existe otra coincidencia, esto lo hace hasta que encuentra 4 coincidencias. 
Cada método de dirección posee la misma lógica y se va moviendo entre las casillas según la dirección en la que esté buscando.

Si un método de dirección encuentra las 4 coincidencias, las retorna y las almacena en una cadena de String. Cuando la cadena cuente con 8 caracteres, finaliza los ciclos y retorna true pues esto significa que ya encontró un ADN de mutante.

