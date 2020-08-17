package tp1.ejercicio1;

public class Main {

	public static void main(String[] args) {
		Grupo grupo = new Grupo("2");

		agregarIntegrante("Ornella", grupo);
		agregarIntegrante("Lucas", grupo);
		agregarIntegrante("Mariano", grupo);
		agregarIntegrante("Andres", grupo);
		agregarIntegrante("Alejandro", grupo);
		agregarIntegrante("Fantasma", grupo);

		probarExistencia(grupo, "Alejandro");

		grupo.mostrar();

		System.out.println("Se removió al participante " + grupo.removerIntegrante("Fantasma"));
		grupo.removerIntegrante("Fantasma");

		grupo.mostrar();
		grupo.vaciar();
		grupo.mostrar();
	}

	private static void agregarIntegrante(String nombre, Grupo grupo) {
		grupo.agregarIntegrante(nombre);
		System.out.println(nombre + " fue asignado al grupo " + grupo.getNombre());
	}

	private static void probarExistencia(Grupo grupo, String nombreABuscar) {
		String nombre = grupo.buscarIntegrante(nombreABuscar);

		if (nombre != null) {
			System.out.println("El integrante: " + nombreABuscar + " fue agregado con éxito");
		} else {
			System.out.println("El integrante no fue agregado");
		}
	}
}
