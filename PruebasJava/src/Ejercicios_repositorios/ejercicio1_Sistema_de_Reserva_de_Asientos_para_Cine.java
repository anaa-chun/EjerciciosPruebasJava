package Ejercicios_repositorios;

import java.util.Scanner;

public class ejercicio1_Sistema_de_Reserva_de_Asientos_para_Cine {

	private static char[][] asientos;

	public static void main(String[] args) {
		inicializarAsientos();
		mostrarAsientos();
		reservarAsientos();
	}

	private static void inicializarAsientos() {
		asientos = new char[10][10]; // 10 filas y 10 columnas

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				asientos[i][j] = 'L'; // 'L' representa los asientos libres
			}
		}
	}

	private static void mostrarAsientos() {
		System.out.println("Estado actual de los asientos:");
		System.out.println(" 1 2 3 4 5 6 7 8 9 10");

		for (int i = 0; i < 10; i++) {
			System.out.print((char) ('A' + i) + " ");
			for (int j = 0; j < 10; j++) {
				System.out.print(asientos[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void reservarAsientos() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Introduzca la fila y la columna del asiento que desea reservar (o 'salir' para salir):");
			String input = scanner.nextLine().toUpperCase();

			if (input.equals("SALIR")) {
				break;
			}

			char fila = input.charAt(0);
			int columna = input.length() > 1 ? Character.getNumericValue(input.charAt(1)) - 1 : -1;

			if (fila >= 'A' && fila < 'A' + 10 && columna >= 0 && columna < 10) {
				if (asientos[fila - 'A'][columna] == 'L') {
					asientos[fila - 'A'][columna] = 'O'; // 'O' representa asientos ocupados
					System.out.println("¡Reserva exitosa!");
					mostrarAsientos();
				} else {
					System.out.println("El asiento ya está reservado. Por favor, elija otro asiento.");
				}
			} else {
				System.out.println("Entrada inválida. Por favor, ingrese una fila válida (A-J) y columna válida (1-10).");
			}
		}

		System.out.println("Gracias por usar el sistema de reserva de asientos. ¡Hasta luego!");
		scanner.close();
	}
}
