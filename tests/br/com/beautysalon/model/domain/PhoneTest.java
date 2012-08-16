/**
 * 
 */
package br.com.beautysalon.model.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Jonathan
 *
 */
public class PhoneTest {

	private Phone phone;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.phone =  new Phone();
	}

	/**
	 * Valida se o telefone fixo � v�lido
	 * Test method for {@link br.com.beautysalon.model.domain.Phone#validate()}.
	 */
	@Test
	public void testValidHomePhone() {
		this.phone = this.getValidHomePhone();
		assertTrue(this.phone.validate());
	}
	
	/**
	 * Valida de o telefone celular � v�lido
	 * Test method for {@link br.com.beautysalon.model.domain.Phone#validate()}.
	 */
	@Test
	public void testValidCellPhone() {
		this.phone = this.getValidCellPhone();
		assertTrue(this.phone.validate());
	}
	
	/**
	 * Retorna um objeto {@link Phone} do tipo {@link PhoneType#CELL} v�lido
	 * @return
	 */
	public Phone getValidCellPhone(){
		Phone phone = new Phone();
		phone.setId(1);
		phone.setDdd(11);
		phone.setNumber(976748951);
		phone.setType(PhoneType.CELL);
		
		return phone;
	}
	
	/**
	 * Retorna um objeto {@link Phone} do tipo {@link PhoneType#HOME} v�lido
	 * @return
	 */
	public Phone getValidHomePhone(){
		Phone phone = new Phone();
		phone.setId(1);
		phone.setDdd(11);
		phone.setNumber(40282679);
		phone.setType(PhoneType.HOME);
		
		return phone;
	}
}