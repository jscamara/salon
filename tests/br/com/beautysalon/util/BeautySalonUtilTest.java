/**
 * 
 */
package br.com.beautysalon.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.beautysalon.util.BeautySalonUtil;

/**
 * @author Jonathan
 *
 */
public class BeautySalonUtilTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Valida se a string está nula ou vazia
	 * Test method for {@link br.com.beautysalon.util.BeautySalonUtil#isEmpty(java.lang.String)}.
	 */
	@Test
	public void testIsEmpty() {
		String value = null;
		assertTrue(BeautySalonUtil.isEmpty(value));
		value = "";
		assertTrue(BeautySalonUtil.isEmpty(value));
		value = "   ";
		assertTrue(BeautySalonUtil.isEmpty(value));
	}
	
	/**
	 * Valida se o tamanho do texto tem o máximo permitido
	 * This method for {@link br.com.beautysalon.util.BeautySalonUtil#checkMaxLength(String, int)}.
	 */
	@Test
	public void testValidMaxLength(){
		String text = "Jonathan";
		int maxLength = 8;
		
		assertTrue(BeautySalonUtil.checkMaxLength(text, maxLength));
	}
	
	/**
	 * Valida se o cpf é válido
	 * This method for {@link br.com.beautysalon.util.BeautySalonUtil#isValidCpf(long)}.
	 */
	@Test
	public void testIsValidCpf(){
		long cpf = 34178440888L;
		assertTrue(BeautySalonUtil.isValidCpf(cpf));
	}
}