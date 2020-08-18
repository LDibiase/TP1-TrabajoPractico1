package tp1.ejercicio2y3;

import java.util.ArrayList;

public class Carrera {
	private String nombre;
	private ArrayList<Competidor> competidores;

	public Carrera(String nombre) {
		this.setNombre(nombre);
		this.competidores = new ArrayList<>();
	}

	public String getNombre() {
		return this.nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void addCompetidor(String nombreCompetidor, int num, double tiempo) {
		if (this.buscarCompetidor(num) == null) {
			competidores.add(new Competidor(nombreCompetidor, num, tiempo));
		}
	}

	private Competidor buscarCompetidor(int num) {
		int i = 0;
		boolean enc = false;
		Competidor comp = null;
		while (i < this.competidores.size() && !enc) {
			if (this.competidores.get(i).getNumero() == num) {
				enc = true;
				comp = this.competidores.get(i);
			} else {
				i++;
			}
		}
		return comp;
	}

	public void ganadores() {
		ArrayList<Competidor> corredores = new ArrayList<>(this.competidores);

		ArrayList<Competidor> primeros = obtenerGanadores(this.tiempoGanador(corredores), corredores);
		this.eliminarCompetidores(corredores, primeros);

		ArrayList<Competidor> segundos = obtenerGanadores(this.tiempoGanador(corredores), corredores);
		this.eliminarCompetidores(corredores, segundos);

		ArrayList<Competidor> terceros = obtenerGanadores(this.tiempoGanador(corredores), corredores);
		this.eliminarCompetidores(corredores, terceros);

		System.out.println("Primer puesto: \n" + primeros);
		System.out.println("Segundo puesto: \n" + segundos);
		System.out.println("Tercer puesto: \n" + terceros);
	}

	private ArrayList<Competidor> obtenerGanadores(double tiempo, ArrayList<Competidor> corredores) {
		ArrayList<Competidor> result = new ArrayList<>();

		for (Competidor corredor : corredores) {
			if (corredor.getTiempo() <= tiempo) {
				result.add(corredor);
			}
		}

		return result;
	}

	private double tiempoGanador(ArrayList<Competidor> corredores) {
		int i = 0;
		double min = 99999;
		while (i < corredores.size()) {
			if (corredores.get(i).getTiempo() < min) {
				min = corredores.get(i).getTiempo();
			}
			i++;
		}

		return min;
	}

	private void eliminarCompetidores(ArrayList<Competidor> corredores, ArrayList<Competidor> ganadores) {
		for (Competidor corredor : ganadores) {
			corredores.remove(corredor);
		}
	}
}
