package ar.utn.frba.dds.tpAnual2015.java8;

public class Componente {
	private String comestible;
	private double cantidad;
	private Unidad unidad;
	
	/**
	 * @param comestible
	 * @param cantidad
	 * @param unidad
	 */
	public Componente(String comestible, double cantidad, Unidad unidad) {
		super();
		this.comestible = comestible;
		this.cantidad = cantidad;
		this.unidad = unidad;
	}
	
	public String getComestible() {
		return comestible;
	}
	public void setComestible(String comestible) {
		this.comestible = comestible;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public Unidad getUnidad() {
		return unidad;
	}
	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}
	
	
}
