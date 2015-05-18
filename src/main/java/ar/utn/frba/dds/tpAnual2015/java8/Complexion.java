package ar.utn.frba.dds.tpAnual2015.java8;

public class Complexion {
	private double peso;
	private double estatura;
	
	public Complexion(double peso, double estatura) {
		super();
		this.peso = peso;
		this.estatura = estatura;
	}
	
	public double calcularIMC() {
		return this.peso / Math.pow(this.estatura,2);
	}
	
	public boolean validarAtributos() {
		//FIXME: chequear si existen (que no esten vacios)
		return true;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
}
