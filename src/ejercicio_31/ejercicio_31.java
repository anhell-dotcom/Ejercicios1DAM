package ejercicio_31;

import java.util.Scanner;

public class ejercicio_31 {
	/**
	 * Realiza el juego del “Craps”. Las reglas son las siguientes: Al comenzar la
	 * partida, el jugador introduce la cantidad de dinero que quiere apostar. Se
	 * muestra la tirada aleatoria de dos dados. Si entre los dos dados suman 7 u
	 * 11, el jugador gana la misma cantidad que apostó y termina la partida. Por
	 * ej. si apostó 1000 €, gana otros 1000 € y acaba con 2000 €. Si entre los dos
	 * dados suman 2, 3 o 12, el jugador pierde todo su dinero y termina la partida.
	 * Si no se da ninguno de los casos anteriores, es decir si sale 4, 5, 6, 8, 9 o
	 * 10, el juego entra en una segunda etapa. En esta etapa, el jugador buscará
	 * volver a obtener ese número en los dados. Si consigue repetir ese número,
	 * gana. Si sale un 7, pierde. Si sale otro número, tiene que seguir tirando
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