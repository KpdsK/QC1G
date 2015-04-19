/**
 * 
 */
package ar.utn.frba.dds.tpAnual2015.java8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Pablo David Scalora
 *
 */
public class TestPersona {

	Persona p1;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		p1 = new Persona(86.0,1.86,"Pablo");
	}

	@Test
	public void pruebaCalculoIMCConAltura186Peso86Correcto() {
		assertEquals(24.858365,p1.calcularIMC(),1e-6);
	}
	@Test
	public void pruebaCalculoIMCConAltura186Peso86Incorrecto() {
		assertNotEquals(23,p1.calcularIMC(),1e-6);
	}
}
