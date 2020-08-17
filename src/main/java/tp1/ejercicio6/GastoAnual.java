package tp1.ejercicio6;

import java.util.ArrayList;

public class GastoAnual {
	private final int TOTAL_MESES = 12;

	private ArrayList<Rubro> rubros;

	public GastoAnual() {
		this.rubros = new ArrayList<>();
	}

	public void agregarGasto(Mes mes, String nombreRubro, double importe) {
		Rubro rubro = this.obtenerRubro(nombreRubro);

		if (importe > 0) {
			rubro.agregarGasto(mes, importe);
		}
	}

	private Rubro obtenerRubro(String nombre) {
		Rubro rubro = this.buscarRubro(nombre);

		if (rubro == null) {
			rubro = new Rubro(nombre);
			this.rubros.add(rubro);
		}

		return rubro;
	}

	private Rubro buscarRubro(String nombre) {
		Rubro rubro = null;
		int index = 0;
		while (rubro == null && index < this.rubros.size()) {
			if (this.rubros.get(index).getNombre().equalsIgnoreCase(nombre)) {
				rubro = this.rubros.get(index);
			}
			index++;
		}
		return rubro;
	}

	private double[][] consolidadoDeGastos() {
		double[][] consolidado = new double[TOTAL_MESES][this.rubros.size()];
		int count = 0;

		for (Mes mes : Mes.values()) {
			for (Rubro rubro : this.rubros) {
				consolidado[mes.ordinal()][count] = rubro.getTotalGastos(mes);
				count++;
			}
			count = 0;
		}

		return consolidado;
	}

	public double gastoAcumulado(Mes mes) {
		double acumulado = 0;
		double[][] consolidado = this.consolidadoDeGastos();

		for (int i=0; i < consolidado[mes.ordinal()].length; i++) {
			acumulado += consolidado[mes.ordinal()][i];
		}

		return acumulado;
	}

	public double gastoAcumulado(String nombreRubro) {
		Rubro rubro = this.buscarRubro(nombreRubro);

		if (rubro == null) {
			return -1;
		}

		return rubro.getTotalGastos();
	}

	public void informarConsumosPorMes() {
		for (Mes mes : Mes.values()) {
			System.out.println("Acumulado del mes: " + mes.name());

			for (Rubro rubro : this.rubros) {
				System.out.println(rubro.getNombre() + ": " + rubro.getTotalGastos(mes));
			}
		}
	}

	private double obtenerGastosTotalesPorMes(Mes mes) {
		double acum = 0;
		for (Rubro rubro : this.rubros) {
			acum += rubro.getTotalGastos(mes);
		}

		return acum;
	}

	public void informarPromedioMensualPorRubro() {
		for (Mes mes : Mes.values()) {
			System.out.println("Promedio del mes de: " + mes.name());

			for (Rubro rubro : this.rubros) {
				System.out.println(rubro.getNombre() + ": " +
						((rubro.getTotalGastos(mes) * 100) / rubro.getTotalGastos()));
			}
		}
	}

	public void informarMesMayorConsumo() {
		double max = 0;
		ArrayList<Mes> mesesMax = new ArrayList<>();

		for (Mes mes : Mes.values()) {
			double parcial = this.obtenerGastosTotalesPorMes(mes);

			if (parcial >= max) {
				mesesMax.add(mes);
			}

			if (parcial > max) {
				max = parcial;
				mesesMax.clear();
				mesesMax.add(mes);
			}

		}

		for (Mes mes : mesesMax) {
			System.out.println(mes + " mes MAX con: " + this.obtenerGastosTotalesPorMes(mes));
		}
	}
}
