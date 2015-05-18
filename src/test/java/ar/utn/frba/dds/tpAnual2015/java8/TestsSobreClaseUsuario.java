package ar.utn.frba.dds.tpAnual2015.java8;

import static org.junit.Assert.*;

import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

public class TestsSobreClaseUsuario {

	private String cadenaMayorA4Caracteres, cadenaIgualA4Caracteres, cadenaMenorA4Caracteres;
	private CondicionPreexistente celiaquia, hipertension, diabetes, vegania;
	private Usuario usuarioConAtributosVacios, usuarioConCondicionesPreexistentesSuperadas,
				usuarioConAlgunaCondicionPreexistentenNoSuperadas, usuarioConCondicionesPreexistentesNoSuperadas;
	private Componente azucar;
	private Complexion complexionSaludable;
	
	@Before
	public void setUp() throws Exception {
		complexionSaludable = new Complexion(70, 1.8);
		usuarioConAtributosVacios = new Usuario();
		usuarioConCondicionesPreexistentesSuperadas = new Usuario();
		usuarioConCondicionesPreexistentesNoSuperadas = new Usuario();
		usuarioConAlgunaCondicionPreexistentenNoSuperadas = new Usuario();
		Predicate<Usuario> condicionUsuarioVerdadera  = (usuario)-> true;
		Predicate<Receta> condicionRecetaVerdadera  = (receta)-> true;
		celiaquia = new CondicionPreexistente("Celiaquia", condicionUsuarioVerdadera,
				condicionUsuarioVerdadera, condicionRecetaVerdadera);
		diabetes = new CondicionPreexistente("Diabetes", condicionesLimitacionParaDiabetes,
				condicionesParaSubsanarCondicionesPreexistentesParaDiabetes, condicionesParaRecetaAdecuadaParaDiabetes);
		hipertension = new CondicionPreexistente("Hipertension", condicionesLimitacionParaDiabetes,
				condicionUsuarioVerdadera, condicionRecetaVerdadera);
		vegania = new CondicionPreexistente("Vegania", condicionUsuarioVerdadera,
				condicionUsuarioVerdadera, condicionRecetaVerdadera);
		cadenaMayorA4Caracteres = "NombreConMasDe4Caracteres";
		cadenaIgualA4Caracteres = "4444";
		cadenaMenorA4Caracteres = "333";
		usuarioConCondicionesPreexistentesSuperadas.setSexo(Sexo.FEMENINO);
		usuarioConCondicionesPreexistentesSuperadas.agregarAlimentoPreferido("Naranja");
		usuarioConCondicionesPreexistentesSuperadas.agregarCondicionPreexistente(diabetes);
		usuarioConCondicionesPreexistentesSuperadas.setRutina(Rutina.OTRA);
		usuarioConCondicionesPreexistentesSuperadas.setComplexion(complexionSaludable);
	}
	
	/**
	 * Pruebas sobre clase validarNombre(String).
	 * Responsabilidad: Valida que la cadena propuesta tenga mas de 4 caracteres.
	 * Cantidad de Pruebas 3:
	 * 	*) Cadena mayor a 4 caracteres. Debe validarla positivamente.
	 * 	*) Cadena igual a 4 caracteres. Debe validarla negativamente.
	 * 	*) Cadena menor a 4 digitos. Debe validarla negativamente.
	 */
	@Test
	public void testCadenaPropuestaParaNombreMenorA4CaracteresFalla() {
		assertFalse("El Nombre propuesto NO es MENOR a 4 caracteres",
				usuarioConAtributosVacios.validarNombre(cadenaMenorA4Caracteres));
	}

	@Test
	public void testCadenaPropuestaParaNombreIgualA4CaracteresFalla() {
		assertFalse("El Nombre propuesto NO es IGUAL a 4 caracteres",
				usuarioConAtributosVacios.validarNombre(cadenaIgualA4Caracteres));
	}
	
	@Test
	public void testCadenaPropuestaParaNombreMayorACaracteresPasa() {
		assertTrue("El Nombre propuesto NO es MAYOR a 4 caracteres",
				usuarioConAtributosVacios.validarNombre(cadenaMayorA4Caracteres));
	}
	
	/**
	 * Pruebas sobre clase superoLimitacionesDeCondicionesPreexistentes().
	 * Responsabilidad: Valida que las limitaciones de las condiciones preexistentes sean superadas.
	 * Cantidad de Pruebas 3:
	 * 	Validar coleccion de condiciones preexistentes vacia. Valida positivamente.
	 * 	Validar coleccion de condiciones preexistentes, donde alguna no supere dicha limitacion. Valida negativamente.
	 * 	Validar coleccion de condiciones preexistentes, donde ninguna supere la limitacion. Valida negativamente.
	 *  Validar coleccion de condiciones preexistentes, donde todas superen las limitacion. Valida positivamente.
	 */
	@Test
	public void testUsuarioConColeccionPreexistentesVaciaPasa() {
		assertTrue("La coleccion vacia no paso la prueba",
				usuarioConAtributosVacios.superoLimitacionesDeCondicionesPreexistentes());
	}

	/*@Test
	public void testUsuarioConColeccionPreexistentesDondeAlgunaNoSupereLaLimitacionFalla() {
		assertFalse("Ninguna condicion hizo fallar la prueba",
				usuarioConCondicionesPreexistentesNoSuperadas.superoLimitacionesDeCondicionesPreexistentes());
	}
	
	@Test
	public void testUsuarioConColeccionPreexistentesDondeNingunaSupereLaLimitacionFalla() {
		assertTrue("La coleccion vacia no paso la prueba",
				usuarioConAlgunaCondicionPreexistentenNoSuperadas.superoLimitacionesDeCondicionesPreexistentes());
	}*/
	
	@Test
	public void testUsuarioConColeccionPreexistentesDondeTodasSuperenLaLimitacionPasa() {
		assertTrue("Alguna/s de las condiciones no supero o superaron la/s limitacion/es",
				usuarioConCondicionesPreexistentesSuperadas.superoLimitacionesDeCondicionesPreexistentes());
	}
}