package ar.utn.frba.dds.tpAnual2015.java8;

abstract class CondicionPreexistente {
	
	private String nombre;
	
	/**
	 * @param nombre
	 */
	public CondicionPreexistente(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	protected boolean tieneDefinidoAlgunAlimentoPreferidoUsuario(Usuario usuario) {
		return ! usuario.getAlimentosPreferidos().isEmpty();
	}

	//Metodos publicos funcionalidad de la Clase (interface)
	//Solución que depende de la tecnologia, no lo resuelve el diseño.
	public abstract boolean superaLimitacionElUsuario( Usuario usuario );
	
	public abstract boolean subsanaCondicionPreexistenteUsuario( Usuario usuario );
	
	public abstract boolean esAdecuadaLaReceta( Receta receta );

	@Override
	public String toString() {
		return "CondicionPreexistente [nombre=" + nombre + "]";
	}
}