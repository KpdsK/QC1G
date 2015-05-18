package ar.utn.frba.dds.tpAnual2015.java8;

public class Diabetes extends CondicionPreexistente {

	public Diabetes() {
		super("Diabetes");
	}

	private boolean tieneDefinidoSexoUsuario(Usuario usuario) {
		return ! usuario.getSexo().equals(null);
	}
	
	private boolean cantidadDeAzucarPermitida(Receta receta) {
		return ! ((receta.getCondimentos().stream().
				filter(condimento -> condimento.getComestible().
				toUpperCase().equals("AZUCAR")).findFirst()).
				get().getCantidad() > 100);
	}
	
	private boolean pesoAdecuadoDeUsuario(Usuario usuario) {
		return usuario.getComplexion().getPeso()<71;
	}

	@Override
	public boolean superaLimitacionElUsuario(Usuario usuario) {
		return tieneDefinidoSexoUsuario(usuario) && tieneDefinidoAlgunAlimentoPreferidoUsuario(usuario);
	}

	@Override
	public boolean subsanaCondicionPreexistenteUsuario(Usuario usuario) {
		return pesoAdecuadoDeUsuario(usuario) || usuario.getRutina().esActiva();
	}

	@Override
	public boolean esAdecuadaLaReceta(Receta receta) {
		return cantidadDeAzucarPermitida(receta);
	}

}