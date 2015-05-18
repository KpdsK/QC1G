package ar.utn.frba.dds.tpAnual2015.java8;

public class Hipertension extends CondicionPreexistente {

	public Hipertension() {
		super("Hipertension");
	}
	
	@Override
	public boolean superaLimitacionElUsuario(Usuario usuario) {
		return tieneDefinidoAlgunAlimentoPreferidoUsuario(usuario);
	}

	@Override
	public boolean subsanaCondicionPreexistenteUsuario(Usuario usuario) {
		return usuario.getRutina().esIntensiva();
	}

	@Override
	public boolean esAdecuadaLaReceta(Receta receta) {
		return false;
	}

}
