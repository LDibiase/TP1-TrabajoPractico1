package tp1.ejercicio6;

import java.util.Random;

public class Main {
	private static final double RANGE_MIN = 0;
	private static final double RANGE_MAX = 10000;

	public static void main(String[] args) {
		GastoAnual gastoAnual = new GastoAnual();

		cargarGastos(gastoAnual, "Alquiler");
		cargarGastos(gastoAnual, "Compras");
		cargarGastos(gastoAnual, "Extras");

		gastoAnual.informarConsumosPorMes();
		gastoAnual.informarPromedioMensualPorRubro();
		gastoAnual.informarMesMayorConsumo();
	}

	private static void cargarGastos(GastoAnual gastoAnual, String nombreRubro) {
		Random r = new Random();

		for (Mes mes : Mes.values()) {
			double randomValue = RANGE_MIN + (RANGE_MAX - RANGE_MIN) * r.nextDouble();
			gastoAnual.agregarGasto(mes, nombreRubro, randomValue);
		}
	}
}
