package tp1.ejercicio4y5;

public class AnioV2 {
	private String[] mes;
	private Integer[] dia;

	public AnioV2() {
		fillArray();
		//this.mes= new String [] {"Enero", "Febrero", "Marzo", "Abril", "Mayo","Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"};
		this.dia= new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
	}

	public void fillArray() {
		this.mes = new String[Mes.values().length];
		for (int i=0; i<Mes.values().length; i++) {
			this.mes[i] = Mes.values()[i].name();
		}
	}

	public String getNombreDelMes(int numeroMes) {
		String mes=null;
		int i=0;
		while(i<this.mes.length && i!=numeroMes-1) {
			i++;
		}
		mes=this.mes[i];
		return mes;
	}

	public int getNumeroDia (int posArray) {
		return this.dia[posArray-1];
	}


	public int diasTranscurridos(int numeroMes) {
		int dias=0;

		if(numeroMes>1) {
			dias=this.dia[30];
			if(numeroMes>2) {
				dias+=this.dia[27];
				if(numeroMes>3) {
					dias+=this.dia[30];
					if(numeroMes>4) {
						dias+=this.dia[29];
						if(numeroMes>5) {
							dias+=this.dia[30];
							if(numeroMes>6) {
								dias+=this.dia[29];
								if(numeroMes>7) {
									dias+=this.dia[30];
									if(numeroMes>8) {
										dias+=this.dia[30];
										if(numeroMes>9) {
											dias+=this.dia[29];
											if(numeroMes>10) {
												dias+=this.dia[30];
												if(numeroMes>11) {
													dias += this.dia[29];

												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return dias;
	}
}
