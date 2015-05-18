package ar.utn.frba.dds.tpAnual2015.java8;

public enum Unidad {
	KILOGRAMO("kg"), UNIDADES("unid"), CUCHARADAS("cdas"), LATA("lata"), MILILITROS("ml"), GRAMOS("grs"),
	CANTIDADNECESARIA("C/N"), SINUNIDAD("");
	private String nombre;

	private Unidad(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
}
