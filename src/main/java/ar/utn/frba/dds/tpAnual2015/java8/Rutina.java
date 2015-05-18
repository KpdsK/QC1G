package ar.utn.frba.dds.tpAnual2015.java8;

public enum Rutina {
	LEVE("Leve"), NADA("Nada"), MEDIANO("Mediano"), INTENSIVO("Intensivo"), OTRA("Otra");
	private String nombre;

	private Rutina(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean esActiva() {
		//TODO: Buscar opciones, no me agrada comparar strings
		return (esIntensiva()|| this == Rutina.OTRA);
	}

	public boolean esIntensiva() {
		//TODO: Buscar opciones, no me agrada comparar strings
		return (this == Rutina.INTENSIVO);
	}
}
