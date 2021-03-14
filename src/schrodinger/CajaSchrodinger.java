package schrodinger;

import java.util.ArrayList;

// Por convenio se le pone E de "Element"
public class CajaSchrodinger<E> {

	private E Animales;

	public CajaSchrodinger(E Animales) {
		this.Animales = Animales;
	}

	public E getAnimales() {
		return Animales;
	}

	public void imprimir() {
		System.out.println(Animales.toString());
	}

	/**
	 * Este metodo accede a todos los Animales del ArrayList, en cada elemento hay
	 * un 50% de posibilidades de eliminarlo de la lista (como si muriera...)
	 * 
	 * @param animales es el nombre del ArrayList
	 */
	public void Observar(ArrayList<Animales> animales) {
		for (int i = 0; i < animales.size(); i++) {
			int numeroAleatorio = (int) (Math.random() * 100);
			if (numeroAleatorio < 50) {
				animales.remove(i);
			}
		}
	}
	
}