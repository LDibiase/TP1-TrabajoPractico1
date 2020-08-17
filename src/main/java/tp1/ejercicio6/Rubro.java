package tp1.ejercicio6;

public class Rubro {
	private final int TOTAL_MESES = 12;

	private String nombre;
	private double[] gastosPorMes;

	public Rubro(String nombre) {
		this.nombre = nombre;
		this.gastosPorMes = new double[TOTAL_MESES];
		this.inicializarGastos();
	}

	private void inicializarGastos() {
		for(int i=0; i < this.gastosPorMes.length; i++) {
			this.gastosPorMes[i] = 0;
		}
	}

	public void agregarGasto(Mes mes, double importe) {
		this.gastosPorMes[Mes.valueOf(mes.name()).ordinal()] += importe;
	}

	public String getNombre() {
		return this.nombre;
	}

	public double getTotalGastos(Mes mes) {
		return this.gastosPorMes[Mes.valueOf(mes.name()).ordinal()];
	}

	public double getTotalGastos() {
		double acum = 0;

		for (int i=0; i < this.gastosPorMes.length; i++) {
			acum += this.gastosPorMes[i];
		}

		return acum;
	}
}
