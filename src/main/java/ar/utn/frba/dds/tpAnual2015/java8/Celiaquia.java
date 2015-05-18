package ar.utn.frba.dds.tpAnual2015.java8;

public class Celiaquia extends CondicionPreexistente {

	public Celiaquia() {
		super("Celiaquia");
	}

	@Override
	public boolean superaLimitacionElUsuario(Usuario usuario) {
		return true;
	}

	@Override
	public boolean subsanaCondicionPreexistenteUsuario(Usuario usuario) {
		return true;
	}

	@Override
	public boolean esAdecuadaLaReceta(Receta receta) {
		return true;
	}

}
