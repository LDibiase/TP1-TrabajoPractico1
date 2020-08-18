package tp1.ejercicio2y3;

public class Competidor {
	private String nombre;
	private int numero;
	private double tiempo;

	public Competidor(String nombre, int numero, double tiempo) {
		this.setNombre(nombre);
		this.setNumero(numero);
		this.setTiempo(tiempo);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	private void setNumero(int numero) {
		this.numero = numero;
	}

	public double getTiempo() {
		return tiempo;
	}

	private void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public String toString() {
		return "Competidor [nombre=" + nombre + ", numero=" + numero + ", tiempo=" + tiempo + "]";
	}
}
