package tp1.ejercicio4y5;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int num;
		Scanner ingreso = new Scanner(System.in);
		AnioV2 esteAnio = new AnioV2();

		System.out.println("Ingresar numero del mes en el que estamos");
		num = ingreso.nextInt();

		diasTranscurridos(num, esteAnio);

		System.out.println("------------------------");
		diasTranscurridosCumple(11, esteAnio, "Mariano", 18);
		diasTranscurridosCumple(5, esteAnio, "Ale", 18);
		diasTranscurridosCumple(7, esteAnio, "Lucas", 2);
		diasTranscurridosCumple(10, esteAnio, "Ornella", 25);
		diasTranscurridosCumple(6, esteAnio, "Andy", 13);

		ingreso.close();

	}
	public static void diasTranscurridos(int numeroMes, AnioV2 esteAnio) {
		System.out.println("Transcurrieron "+esteAnio.diasTranscurridos(numeroMes)+ " días antes que inicie el mes de "+esteAnio.getNombreDelMes(numeroMes));
	}

	public static void diasTranscurridosCumple(int numeroMes, AnioV2 esteAnio, String nom, int numeroDia) {
		System.out.println(nom + " cumple el dia "+ esteAnio.getNumeroDia(numeroDia)+ " del mes de " + esteAnio.getNombreDelMes(numeroMes));
	}
}
