/**
 * 
 */
package br.com.beautysalon.model.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.beautysalon.model.domain.Adress;

/**
 * @author Jonathan
 *
 */
public class AdressTest {

	private Adress adress;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.adress = new Adress();
	}

	/**
	 * Test method for {@link br.com.beautysalon.model.domain.Adress#validate()}.
	 */
	@Test
	public void testValidAdress() {
		this.adress = this.getValidAdress();
		assertTrue(this.adress.validate());
	}

	/**
	 * Test method for {@link br.com.beautysalon.model.domain.Adress#validate()}.
	 */
	@Test
	public void testInvalidAdress() {
		assertFalse(this.adress.validate());
	}
	
	public Adress getValidAdress(){
		Adress adress = new Adress();
		adress.setId(1);
		adress.setStreet("Rua nove de Julho");
		adress.setNumber(123);
		adress.setNeighborhood("Centro");
		adress.setCity("Salto");
		adress.setState("São Paulo");
		adress.setCep(13321490);
		adress.setComplement("Casa");
		
		return adress;
	}
}
