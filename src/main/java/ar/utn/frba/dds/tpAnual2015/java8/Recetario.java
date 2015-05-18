package ar.utn.frba.dds.tpAnual2015.java8;

import java.util.Collection;
import java.util.HashSet;

public class Recetario {
	private Collection<Receta> recetasPrivadas = new HashSet<Receta>();
	private Collection<Receta> recetasPublicas = new HashSet<Receta>();
	
	/**
	 * @param recetasPrivadas
	 * @param recetasPublicas
	 */
	public Recetario(Collection<Receta> recetasPrivadas,
			Collection<Receta> recetasPublicas) {
		super();
		this.recetasPrivadas = recetasPrivadas;
		this.recetasPublicas = recetasPublicas;
	}
	
	private static HashSet<Receta> unirColeccionRecetas(Collection<Receta> recetas1, Collection<Receta> recetas2) {
		HashSet<Receta> tmp = new HashSet<Receta>(recetas1);
	    tmp.addAll(recetas2);
	    return tmp;
	}
	
	private void quitarRecetaPrivada(Receta receta) {
		recetasPrivadas.remove(receta);
	}
	
	private void modificarRecetaPublica(Receta recetaModificada) {
		agregarRecetaPrivada(recetaModificada);
	}

	private void modificarRecetaPrivada(Receta recetaAModificar,
			Receta recetaModificada) {
		quitarRecetaPrivada(recetaAModificar);
		agregarRecetaPrivada(recetaModificada);
	}

	public void agregarRecetaPrivada(Receta nuevaReceta) {
		recetasPrivadas.add(nuevaReceta);
	}
	
	public void modificarReceta(Receta recetaAModificar, Receta recetaModificada) {
		//TODO: Mejorar con diseño, buscar alternativa para no utilizar el condicional
		if (recetasPrivadas.contains(recetaAModificar)) {
			modificarRecetaPrivada(recetaModificada, recetaModificada);
		} else {
			modificarRecetaPublica(recetaModificada);
		}
	}
	
	public boolean tengoReceta(Receta recetaBuscada) {
		return unirColeccionRecetas(recetasPrivadas, recetasPublicas).contains(recetaBuscada);
	}

}
