package tp1.ejercicio1;

public class Grupo {
	private String nombre;
	private String[] integrantes;

	public Grupo(String nombre) {
		this.nombre = nombre;
		this.integrantes = new String[6];
	}

	public String getNombre() {
		return this.nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadIntegrantes() {
		int result = 0;

		for (String nombre : this.integrantes) {
			if (nombre != null) {
				result++;
			}
		}

		return result;
	}

	public void agregarIntegrante(String nombreIntegrante) {
		if (!existeIntegrante(nombreIntegrante)) {
			int i = 0;
			boolean agregado = false;

			while (i < this.integrantes.length && !agregado) {
				if(this.integrantes[i] == null) {
					this.integrantes[i] = nombreIntegrante;
					agregado = true;
				}
				i++;
			}
		}
	}

	private boolean existeIntegrante(String nombreIntegrante) {
		int i = 0;
		boolean result = false;

		while (i < this.integrantes.length && !result) {
			if (this.integrantes[i] == nombreIntegrante) {
				result = true;
			}
			i++;
		}
		return result;
	}

	private int obtenerPosicionIntegrante(String nombreIntegrante) {
		int numInt = -1;
		int i=0;

		while (i < integrantes.length && integrantes[i] != nombreIntegrante) {
			i++;
		}

		if (i < integrantes.length) {
			numInt = i;
		}

		return  numInt;
	}

	public String obtenerIntegrante(int posicion) {
		String result = null;

		if (!existeIntegrante(this.integrantes[posicion])) {
			return result;
		}
		return result = this.integrantes[posicion - 1];
	}

	public String buscarIntegrante(String nombre) {
		String result = null;
		int posicion;

		posicion = obtenerPosicionIntegrante(nombre);

		if (posicion != -1) {
			result = this.integrantes[posicion];
		}

		return result;
	}

	public String removerIntegrante(String nombreIntegrante) {
		int posicion;
		String borrado = "";

		posicion = obtenerPosicionIntegrante(nombreIntegrante);

		if (posicion != -1) {
			borrado = this.integrantes[posicion];
			this.integrantes[posicion] = null;
		}

		return borrado;
	}

	private void mostrarIntegrantes() {
		System.out.println("La cantidad de integrantes es: " + this.getCantidadIntegrantes());
		for (int i = 0; i < this.integrantes.length; i++) {
			if (this.integrantes[i] != null) {
				System.out.println(this.integrantes[i]);
			}
		}
	}

	public void mostrar() {
		System.out.println("El nombre del grupo es: " + this.getNombre());
		this.mostrarIntegrantes();
	}

	public void vaciar() {
		for (int i = 0; i < this.integrantes.length; i++) {
			this.integrantes[i] = null;
		}
	}
}
