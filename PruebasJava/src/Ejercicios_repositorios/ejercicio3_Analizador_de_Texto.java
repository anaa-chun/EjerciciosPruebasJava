package Ejercicios_repositorios;

import java.util.Scanner;

//@author: Ana Chun Gómez de Castro DAM1

public class ejercicio3_Analizador_de_Texto {

	public void main(String[] args) {

		/*
		 * - Descripción: Implementar un programa que analice un texto ingresado por el
		 * usuario o leído de un archivo. Debe proporcionar estadísticas como el número
		 * de palabras, frecuencia de cada palabra, longitud promedio de las palabras,
		 * etc. - Retos: Procesamiento de texto, manejo de archivos, y cálculo de
		 * estadísticas relevantes.
		 * 
		 * 
		 * -Pasos: 1. Pide al usuario un texto o el nombre de un archivo de texto para
		 * analizar.
		 * 
		 * 2. Lee el texto y divídelo en palabras.
		 * 
		 * 3. Para cada palabra,actualiza las estadísticas: cuenta el número total de
		 * palabras, la frecuencia de cada palabra, la longitud promedio, etc.
		 * 
		 * 4. Al final, muestra todas las estadísticas calculadas.
		 * 
		 * 5. Considera casos especiales como signos de puntuación o palabras repetidas.
		 */

		String texto;
		String palabra;

		Scanner scanner = new Scanner(System.in);
		System.out.println(" Introduzca un texto o un una ruta del archivo de texto: ");
		String casa = scanner.nextLine();

		if (esRutaDeArchivo(casa)) {
			texto = leerArchivo(casa);
		} else {
			texto = casa;
		}

		String palabras[] = texto.split(" \\s+"); // Lee el texto y lo divide en palabras.

		int totalPalabras = palabras.length;
		int longitudTotal = 0;

		for (String palabra : palabra) {
			// Limpia la palabra eliminando signos de puntuación al inicio o al final
			palabra = palabra.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "");

			frecuenciaPalabras.put(palabra.toLowerCase(),
					frecuenciaPalabras.getOrDefault(palabra.toLowerCase(), 0) + 1);
			longitudTotal += palabra.length();
		}

		
		//Aquí se muestra todas las características calculadas
		System.out.println("Estadisticas del texto: ");
		System.out.println("Numero total de palabras: " + totalPalabras);
		System.out.println("Longitud promedio de las palabras: " + (double) longitudTotal / totalPalabras);

		System.out.println("\frecuencia de cada palabra");
		for (Map.Entry<String, Integer> entry : frecuenciaPalabras.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());

			// No sé cual es la estructura de programación para la frecuencia
		}
		scanner.close();

	}

}
