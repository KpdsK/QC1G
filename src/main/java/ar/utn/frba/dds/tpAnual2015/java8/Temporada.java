package ar.utn.frba.dds.tpAnual2015.java8;

public enum Temporada {
	VERANO("Verano"), OTOÑO("Otoño"), INVIERNO("Invierno"), PRIMAVERA("Primavera"), TODAS("Todas");
	private String nombre;

	/**
	 * @param nombre
	 */
	private Temporada(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
}
