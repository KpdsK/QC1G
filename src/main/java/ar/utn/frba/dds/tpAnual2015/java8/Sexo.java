package ar.utn.frba.dds.tpAnual2015.java8;

public enum Sexo {
	MASCULINO("Masculino"), FEMENINO("Femenino");
	private String nombre;

	private Sexo(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
}
