package schrodinger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainApp {
	/**
	 * Cread la clase gen�rica CajaSchrodinger que no solo aceptar� gatos. Aceptar�
	 * cualquier tipo de animal pero solo animales. Despu�s, cread una lista de
	 * animales (5) y recorredla.
	 * 
	 * Ir�is introduciendo uno por uno en la caja. La caja tendr� un m�todo que se
	 * llamar� observar. Aleatoriamente la mitad de las veces que se observe el
	 * animal morir�, por lo que el m�todo observar devolver� NULL y en la lista se
	 * de animales dejar� de existir ese animal y se guardar� NULL pues ha muerto.
	 * Si sobrevive, se le dejar� en la lista.
	 * 
	 * Por �ltimo mostrar todos los animales que han sobrevivido a la caja de
	 * Schr�dinger.
	 */

	public static void main(String[] args) {

		CajaSchrodinger<Animales> lista = new CajaSchrodinger<Animales>(new Perros("Rosa", 40, 16, 15));

		List<Animales> listDeAnimales = new ArrayList<Animales>();

		// muestra los animales que hay en la lista de "genericos"
		// lista.imprimir();

		listDeAnimales.add(new Perros("Boby", 42.2, 11, 6));
		listDeAnimales.add(new Perros("Leon", 20, 6, 19));
		listDeAnimales.add(new Gatos("Misifu", 20, 6, 19));
		listDeAnimales.add(new Gatos("Isidoro", 20, 6, 19));
		listDeAnimales.add(new Tortugas("Ariel", 20, 6, 19));

		// muestra los animales que hay en el ArraList inicialmente
		System.out.println("Estos son los animales que hay: ");
		for (Animales animales : listDeAnimales) {
			System.out.println(animales);
		}

		// listDeAnimales.Observar(); no se ejecuta...

		// Ejecucion del metodo Observar();
		for (int i = 0; i < listDeAnimales.size(); i++) {
			int numeroAleatorio = (int) (Math.random() * 100);
			if (numeroAleatorio < 50) {
				listDeAnimales.remove(i);
			}
		}

		System.out.println();
		System.out.println("Y estos los animales que quedan despues de haber pasado por la Caja Schrodinger:");
		// Muestra los animales que sobrevivieron en el ArrayList mediante Iterator
		Iterator<Animales> it = listDeAnimales.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}