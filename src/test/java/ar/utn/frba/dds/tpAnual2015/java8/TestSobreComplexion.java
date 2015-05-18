package ar.utn.frba.dds.tpAnual2015.java8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSobreComplexion {
	
	Complexion complexionPablo, complexionSilvina, complexionEzequiel, complexionSantiago, complexionGustavo;
	
	@Before
	public void setUp() throws Exception {
		complexionPablo = new Complexion(86, 1.86);
		complexionSilvina = new Complexion (52,1.6);
		complexionEzequiel = new Complexion(83,1.88);
		complexionSantiago = new Complexion (82,1.8);
		complexionGustavo = new Complexion (65, 1.7);
	}

	/**
	 * Pruebas sobre metodo calcularIMC()
	 */
	
	@Test
	public void pruebaCalculoIMCPabloCorrecto() {
		assertEquals(24.858365, complexionPablo.calcularIMC(), 1e-6);
	}
	
	@Test
	public void pruebaCalculoIMCPabloIncorrecto() {
		assertNotEquals(23, complexionPablo.calcularIMC(), 1e-6);
	}
	
	@Test
	public void pruebaCalculoIMCEzequielCorrecto() {
		assertEquals(23.48, complexionEzequiel.calcularIMC(), 1e-2);
	}

	@Test
	public void pruebaCalculoIMCSilvinaCorrecto() {
		assertEquals(20.3125, complexionSilvina.calcularIMC(), 1e-6);
	}

	@Test
	public void pruebaCalculoIMCSilvinaIncorrecto() {
		assertNotEquals(50, complexionSilvina.calcularIMC(), 1e-6);
	}

	@Test
	public void pruebaCalculoIMCSantiagoCorrecto() {
		assertEquals(25.308641, complexionSantiago.calcularIMC(), 1e-6);
	}

	@Test
	public void pruebaCalculoIMCSantiagoIncorrecto() {
		assertNotEquals(25, complexionSantiago.calcularIMC(), 1e-6);
	}
	
	@Test
	public void pruebaCalculoIMCGustavoCorrecto() {
		assertEquals(22.491349, complexionGustavo.calcularIMC(), 1e-6);
	}
	
	@Test
	public void pruebaCalculoIMCGustavoIncorrecto() {
		assertNotEquals(22, complexionGustavo.calcularIMC(), 1e-6);
	}
	
}
