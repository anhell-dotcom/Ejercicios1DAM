package ejercicio_31;

import java.util.Scanner;

public class ejercicio_31 {
	/**
	 * Juego del “Craps”. En versión para consola
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// declaracion de variables
		int dineroApuesta = 0;
		int tiradaPrimera = 0;
		int tiradaSegunda = 0;
		int sumaTiradas = 0;
		int comprobacionEntero = 0;
		boolean finDelJuego;

		System.out.println("Bienvenido al juego del Craps, tiraras 2 dados");

		// validamos que el usuario ingrese un numero entero
		do {
			try {
				System.out.println("¿Que cantidad de dinero quieres apostar?");
				dineroApuesta = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("El numero no es valido");
				comprobacionEntero = 1;
				sc.nextLine();
			}
		} while (comprobacionEntero != 0);


		tiradaPrimera = (int) (Math.random() * 6 + 1);
		tiradaSegunda = (int) (Math.random() * 6 + 1);
		sumaTiradas = tiradaPrimera + tiradaSegunda;

		System.out.println("el resultado de las tiradas son: " + tiradaPrimera + " y " + tiradaSegunda);
		System.out.println("La suma de las dos tiradas es: " + sumaTiradas);

		switch (sumaTiradas) {
		case 7:
		case 11:
			System.out.println("Has ganado el doble de lo que apostaste: " + dineroApuesta * 2 + "€");
			break;
		case 2:
		case 3:
		case 12:
			System.out.println("Has perdido todo tu dinero. GAME OVER");
			break;
		default:
			System.out.println("Ahora lanzarás los dos dados hasta que saques " + sumaTiradas
					+ " para ganar, o saques un 7 en el total para perder la partida. Pulsa intro");
			sc.nextLine();
			finDelJuego = false;

			do {
				tiradaPrimera = (int) (Math.random() * 6 + 1);
				tiradaSegunda = (int) (Math.random() * 6 + 1);

				System.out.println("Dado 1: " + tiradaPrimera);
				System.out.println("Dado 2: " + tiradaSegunda);
				System.out.println("Suma: " + (tiradaPrimera + tiradaSegunda));

				if ((tiradaPrimera + tiradaSegunda) == sumaTiradas) {
					System.out.println("Has ganado el doble de lo que apostaste: " + dineroApuesta * 2 + "€");
					finDelJuego = true;
				} else if ((tiradaPrimera + tiradaSegunda) == 7) {
					System.out.println("Mala suerte, has perdido toda tu apuesta...");
					finDelJuego = true;
				} else {
					System.out.println("Pulse el boton intro para lanzar de nuevo los dados");
					sc.nextLine();
				}
			} while (!finDelJuego);
		}
		System.out.println("Juego terminado");
		sc.close();
	}
}