package Ejercicios_repositorios;

import java.util.Scanner;

//@author: Ana Chun Gómez de Castro DAM1

public class ejercicio2_Simulador_de_Cajero_Automático {

	// Mario creo que este ejercicio lo tengo mal porque no compila cuando
	// introduzco el numero mayor, lo he intentado pero lo subo

	/*
	 * 2.Simulador de Cajero Automático - Descripción: Desarrollar un simulador de
	 * cajero automático que permita retirar dinero, depositar y consultar saldo. El
	 * programa debe manejar cuentas múltiples con ID y contraseña. - Retos: Crear
	 * un sistema de autenticación, manejar el saldo de las cuentas, y realizar
	 * operaciones básicas de un cajero automático.
	 * 
	 * 
	 * -Pasos: 1. Crea estructuras para almacenar la información de las cuentas (por
	 * ejemplo, usando arrays para IDs, contraseñas y saldos).
	 * 
	 * 2. Implementa un sistema de login que pida al usuario su ID y contraseña y
	 * verifique estos datos. 3. Una vez autenticado, muestra un menú con opciones
	 * como retirar, depositar y ver saldo.
	 * 
	 * 4. Para cada opción, realiza las operaciones correspondientes (actualizar
	 * saldo, mostrar información, etc.).
	 * 
	 * 5. Asegúrate de validar las entradas del usuario (por ejemplo, no permitir
	 * retirar más dinero del disponible en la cuenta).
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Aquí es el Arrays donde he almacenado la información de las cuentas
		int[] ID = { 111, 345, 908, 657, 432 }; // Almacena los IDs de las cuentas
		String[] contrasena = { "casa", "dinero", "seguridad", "suelo", "ladrillo734" }; // Lo que guardo las
																							// contraseñas
		double[] saldo = { 1269.0, 125.0, 22.0, 2300.0, 500.0 }; // Aquí son los datos de los saldos

		System.out.println("Ingrese su ID y contraseña: ");
		int IDU = scanner.nextInt();
		String contrasenaU = scanner.next();

		// Esta es la autenticación del usuario
		int indiceCuenta = autenticarUsuario(ID, contrasena, IDU, contrasenaU);
		// Llamo a la función autenticarUsuario para verificar la autenticación del
		// usuario.

		if (indiceCuenta != -1) {
			// Aquí muestro el menú de opciones

			while (true) {
				// He utilizado esta estructura para mostrar un menú de opciones continuamente
				// hasta que el usuario elija salir (opción 4).

				mostrarMenu();
				int opcion = scanner.nextInt();

				// Ésta realiza operaciones
				switch (opcion) {
				// Ejecuto operaciones específicas según la opción seleccionada por el usuario.
				case 1:
					retirarDinero(saldo, indiceCuenta, scanner);
					break;
				case 2:
					depositarDinero(saldo, indiceCuenta, scanner);
					break;
				case 3:
					consultarSaldo(saldo, indiceCuenta);
					break;
				case 4:
					System.out.println("Gracias por utilizar el simulador, ¡Hasta luego!");
					System.exit(0); // Aquí lo que hace es cerrar el programa cuando el usuario elija salir.
				default:
					System.out.println("Opción no válida. Debes introducir un número desde 1 hasta 4.");
				}
			}
		} else {
			System.out.println("Valores incorrectas. El programa se cerrará.");
			scanner.close();
		}
	}

	private static int autenticarUsuario(int[] IDs, String[] contrasenas, int ID, String contrasena) {
		for (int i = 0; i < IDs.length; i++) {
			if (IDs[i] == ID && contrasenas[i].equals(contrasena)) {
				System.out.println("Inicio de sesión exitoso.");
				return i;
			}
		}
		return -1;
	}

	private static void mostrarMenu() {
		System.out.println("\nMenú de Opciones:");
		System.out.println("1. Retirar dinero");
		System.out.println("2. Depositar dinero");
		System.out.println("3. Consultar saldo");
		System.out.println("4. Salir");
		System.out.print("Elige una opción (1-4): ");

		// Imprime el menú de opciones disponibles para el usuario en la consola.
	}

	private static void retirarDinero(double[] saldo, int indiceCuenta, Scanner scanner) {

		// Permite al usuario retirar una cantidad específica de dinero de su cuenta,
		// siempre y cuando la cantidad sea mayor que 0 y no exceda el saldo disponible
		// en la cuenta.

		System.out.print("Ingresa la cantidad a retirar: ");
		double cantidadRetirar = scanner.nextDouble();
		if (cantidadRetirar > 0 && cantidadRetirar <= saldo[indiceCuenta]) {
			saldo[indiceCuenta] -= cantidadRetirar;
			System.out.println("Retiro exitoso. Saldo actual: " + saldo[indiceCuenta]);
		} else {
			System.out.println("Error: Cantidad no válida o insuficiente saldo.");
		}
	}

	private static void depositarDinero(double[] saldo, int indiceCuenta, Scanner scanner) {

		// Deposita una cantidad específica de dinero en su cuenta, siempre y cuando la
		// cantidad sea mayor que 0.

		System.out.print("Ingresa la cantidad a depositar: ");
		double cantidadDepositar = scanner.nextDouble();
		if (cantidadDepositar > 0) {
			saldo[indiceCuenta] += cantidadDepositar;
			System.out.println("Saldo actual: " + saldo[indiceCuenta]);
		} else {
			System.out.println("Error: Cantidad no válida.");
		}
	}

	private static void consultarSaldo(double[] saldo, int indiceCuenta) {
		System.out.println("Saldo actual: " + saldo[indiceCuenta]);

		// Muestra el saldo actual de la cuenta del usuario autenticado.
	}
}
