package ar.utn.frba.dds.tpAnual2015.java8;

import java.util.Collection;

public class Receta {
	
	private String nombre;
	private Collection<Componente> ingredientes;
	private Collection<Componente> condimentos;
	private String explicacion;
	private Temporada temporada;
	private String dificultad;
	private Collection<Receta> subRecetas;
	private int totalCalorias; // FIXME totalCalorias debe ser un double
	   
	//Constructor
	/**
	 * @param nombre
	 * @param ingredientes
	 * @param condimentos
	 * @param explicacion
	 * @param temporada
	 * @param dificultad
	 * @param subRecetas
	 * @param totalCalorias
	 */
	public Receta(String nombre, Collection<Componente> ingredientes,
			Collection<Componente> condimentos, String explicacion,
			Temporada temporada, String dificultad,
			Collection<Receta> subRecetas, int totalCalorias) {
		super();
		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.condimentos = condimentos;
		this.explicacion = explicacion;
		this.temporada = temporada;
		this.dificultad = dificultad;
		this.subRecetas = subRecetas;
		this.totalCalorias = totalCalorias;
	}
	
	//Metodos para obtener contenido (Getters)
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDificultad() {
		return this.dificultad;
	}
	
	public String getExplicacion() {
		return this.explicacion;
	}
	
	
	public void agregarIngrediente(Componente nuevo) {
		ingredientes.add(nuevo);
	}
	
	public void agregarCondimento(Componente nuevo) {
		condimentos.add(nuevo);
	}
	
	public void agregarSubReceta(Receta subRecetaNueva) {
		subRecetas.add(subRecetaNueva);
	}
	
	private boolean tieneIngrediente() {
		return (ingredientes.size() > 0);
	}
	
	private boolean validarCalorias() {
		return (totalCalorias >= 10 && totalCalorias <= 5000);
	}
	
	public boolean soyValida() {
		return tieneIngrediente() && validarCalorias();
	}
	
	public boolean todoElAnio() {
		return (temporada == Temporada.TODAS);
	}

	public Collection<Componente> getCondimentos() {
		return condimentos;
	}
}
