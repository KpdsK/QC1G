package ar.edu.utn.frba.dds.queComemos.java8;

import java.util.Collection;

public class Usuario {
	private Persona persona;
	private Collection<CondicionPreexistente> condicionesPreexistentes;
	private Collection<Alimento> alimentosPreferidos;
	private Collection<Alimento> alimentosRechazados;
	private Rutina rutina;
	
	private void validarUsuario() {
		condicionesPreexistentes.stream().forEach(condicion -> condicion.cumpleLimitaciones(persona));
	}
}
