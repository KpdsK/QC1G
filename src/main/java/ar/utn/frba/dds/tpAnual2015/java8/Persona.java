package ar.utn.frba.dds.tpAnual2015.java8;

public class Persona {
	private double peso;
	private double estatura;
	private String nombre;
	
	/**
	 * @param peso
	 * @param estatura
	 * @param string
	 */
	public Persona(double peso, double estatura, String string) {
		super();
		this.peso = peso;
		this.estatura = estatura;
		this.nombre = string;
	}

	public double calcularIMC() {
		return this.peso / Math.pow(this.estatura,2);
	}
}
