package schrodinger;

public class Animales {
	private String nombre;
	private double altura;
	private double velocidad;
	private int edad;
	
	public Animales(String nombre, double altura, double velocidad, int edad) {
		super();
		this.nombre = nombre;
		this.nombre = nombre;
		this.altura = altura;
		this.velocidad = velocidad;
		this.edad = edad;
	}
	
	public Animales() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Animales [nombre=" + nombre + ", altura=" + altura + ", velocidad=" + velocidad + ", edad=" + edad
				+ "]";
	}
}