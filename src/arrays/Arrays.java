package arrays;

public class Arrays {

	/**
	 * Crear un programa que de 10 números almacenados en un array, los muestre y después 
	 * pasar los números primos a las primeras posiciones, desplazando el resto de números
	 * sin que se pierda ninguno.
	 * A continuación se debe mostrar como quedaría el array final
	 */

	public static void main(String[] args) {
		int[] array = { 8, 7, 6, 3, 5, 20, 21, 13, 9 };
		int[] arrayFinal = new int[9];
		int indice = 0;

		for (int i = 0; i < arrayFinal.length; i++) {
			var num = array[i];

			if (esPrimo(num)) {
				arrayFinal[indice] = num;
				indice++;
			}
		}

		for (int i = 0; i < arrayFinal.length; i++) {
			var num = array[i];

			if (!esPrimo(num)) {
				arrayFinal[indice] = num;
				indice++;
			}
		}
		imprimirArray(arrayFinal);
	}

	public static void imprimirArray(int[] a) {
		System.out.println("Indice: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("Valores ordenados: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static boolean esPrimo(int x) {
		for (int i = 2; i < x; i++) {
			if ((x % i) == 0) {
				return false;
			}
		}
		return true;
	}
}