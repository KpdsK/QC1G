package ar.edu.utn.frba.dds.queComemos.java8;

import java.util.Date;

public class Persona {
	private String nombre;
	private Date fechaNacimiento;
	private Sexo sexo;
	private double peso;
	private double altura;
	
	
	/**
	 * @param nombre
	 * @param fechaNacimiento
	 * @param sexo
	 * @param peso
	 * @param altura
	 */
	public Persona(String nombre, Date fechaNacimiento, Sexo sexo, double peso,
			double altura) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}


	public double calcularIMC() {
		return this.peso / Math.pow(this.altura,2);
	}
}
