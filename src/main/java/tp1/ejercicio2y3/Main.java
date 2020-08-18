package tp1.ejercicio2y3;

import java.util.Scanner;
//Ejercicio 2.
//Para los Juegos Olímpicos de la Juventud nos pidieron un programa con el cual
//podamos calcular quién fue el ganador de una carrera. Para eso ingresaremos un
//atleta y los segundos que ha empleado (con decimales) para recorrer la distancia de
//una especialidad determinada. debe tener en cuenta que puede haber más de un
//ganador (sus tiempos empleados fueron los mismos).
//Ejercicio 3.
//Modificá el ejercicio anterior para que en vez de indicar solamente quién fue el ganador
//obtenga cuál fue la terna ganadora. Debe tener en cuenta que puede haber atletas que
//“empaten” en cualquiera de las tres posiciones del podio.

public class Main {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Carrera carrera = new Carrera("3km");
		addPar(carrera);
		carrera.ganadores();

	}

	public static void addPar(Carrera c) {
		do{
			String nombreCompetidor = ingresoNom();
			int num = ingresoNum();
			double tiempo = ingresoTiempo();
			c.addCompetidor(nombreCompetidor, num, tiempo);
			input.nextLine();
		}while(deseaCont());
	}

	private static String ingresoNom() {
		String nom = null;
		do {
			System.out.println("Ingrese nombre del atleta porfavor");
			nom = input.nextLine();
		} while (nom.isEmpty());
		return nom;
	}

	private static int ingresoNum() {
		int num = 0;
		do {
			System.out.println("Ingrese numero del atleta porfavor");
			num = input.nextInt();
		} while (num == 0);
		return num;
	}

	private static double ingresoTiempo() {
		double tiempo = 0;
		do {
			System.out.println("Ingrese el tiempo del atleta porfavor");
			tiempo = input.nextDouble();
		} while (tiempo == 0);
		return tiempo;
	}
	private static boolean deseaCont(){
		boolean resp = false;
		String rep;
		System.out.println("Desea ingresar otro competidor? SI/NO");
		rep = input.nextLine();
		if(rep.equalsIgnoreCase("si")){
			resp = true;
		}
		return resp;
	}
}
