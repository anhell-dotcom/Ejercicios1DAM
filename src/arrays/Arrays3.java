package arrays;

import java.util.Scanner;

public class Arrays3 {
	/**
	 * Un restaurante nos ha encargado una aplicaci�n para colocar a los clientes en
	 * sus mesas. En una mesa se pueden sentar de 0 (mesa vac�a) a 4 comensales
	 * (mesa llena). Cuando llega un cliente se le pregunta cu�ntos son. De momento
	 * el programa no est� preparado para colocar a grupos mayores a 4, por tanto,
	 * si un cliente dice por ejemplo que son un grupo de 6, el programa dar� el
	 * mensaje �Lo siento, no admitimos grupos de 6, haga grupos de 4 personas como
	 * m�ximo e intente de nuevo�. Para el grupo que llega, se busca siempre la
	 * primera mesa libre (con 0 personas). Si no quedan mesas libres, se busca
	 * donde haya un hueco para todo el grupo, por ejemplo si el grupo es de dos
	 * personas, se podr� colocar donde haya una o dos personas. Inicialmente, las
	 * mesas se cargan con valores aleatorios entre 0 y 4. Cada vez que se sientan
	 * nuevos clientes se debe mostrar el estado de las mesas. Los grupos no se
	 * pueden romper aunque haya huecos sueltos suficientes.
	 */

	public static void main(String[] args) {
		// Declaraci�n de variables
		final int N_MESAS = 4;
		final int MAX_COMENSALES = 4;
		int[] mesas = new int[N_MESAS];
		
		// int[] mesas = {4,3,2,1};
		Scanner sc = new Scanner(System.in);
		int nPersonas = 0;
		boolean estanSentados = false;

		// Inicializa todas las mesas a un n�mero aleatorio de 0 a 4 comensales
		for (int i = 0; i < mesas.length; i++) {
			mesas[i] = (int)(Math.random()*5);
		}
		// Arrays.fill(mesas, 0); //Es lo mismo que el for de arriba
		do {
			do {
				imprimirEstadoMesas(mesas);
				System.out.println();
				System.out.print("�Cu�ntas personas se van a sentar hoy? (-1 para cerrar programa): ");
				nPersonas = Integer.parseInt(sc.nextLine());

				if (nPersonas == -1) {
					System.out.println("Venga, nos vemos beibi");
					sc.close();
					System.exit(0);
				}

				if (nPersonas < 1 || nPersonas > 4) {
					System.out.println(
							"ERROR: No se puede sentar ese n�mero hoy, por favor introduzca un n�mero de personas entre 1 y 4.");
				}
				System.out.println("\n");
			} while (nPersonas < 1 || nPersonas > 4);

			// De momento el grupo no se ha sentado
			estanSentados = false;

			// Intentar sentar en una mesa vac�a
			for (int i = 0; i < mesas.length; i++) {
				if (mesas[i] == 0) {
					mesas[i] = nPersonas;
					estanSentados = true;
					break;
				}
			}

			// Si no se ha sentado, sentar si cabe en alguna mesa
			if (!estanSentados) {
				for (int i = 0; i < mesas.length; i++) {
					if (mesas[i] + nPersonas <= MAX_COMENSALES) {
						mesas[i] = mesas[i] + nPersonas;
						estanSentados = true;
						break;
					}
				}
			}

			if (!estanSentados) {
				System.out.println("Ahora mismo no tenemos mesas disponibles, vuelve a intentarlo despu�s.");
			}
		} while (true);

	}

	public static void imprimirEstadoMesas(int[] mesas) {
		// Imprimir estado de las mesas
		System.out.print("Mesas n�:\t");
		for (int i = 0; i < mesas.length; i++) {
			System.out.print((i + 1) + " ");
		}
		System.out.println();
		System.out.print("Comensales:\t");
		for (int i = 0; i < mesas.length; i++) {
			System.out.print(mesas[i] + " ");
		}
	}
}