/**
 * 
 */
package br.com.beautysalon.util;

import static org.junit.Assert.assertTrue;

import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.core.SafeResourceBundle;

/**
 * @author Jonathan
 *
 */
public class BeautySalonUtilTest {
	public static ResourceBundle	bundle;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	
	static {
		BeautySalonUtilTest.bundle = new SafeResourceBundle(ResourceBundle.getBundle("messages"), true);
	}
	
	/**
	 * Return the i18n word from the <b>messages.properties</b> file
	 * 
	 * @param key
	 * @return the i18n word for the specified key
	 */
	public static String i18n(String key) {
		return BeautySalonUtilTest.bundle.getString(key);
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
	
	public static String bigWord(int size){
		StringBuilder word = new StringBuilder();
		while(size-- != 0){
			word.append("a");
		}
		return word.toString();
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