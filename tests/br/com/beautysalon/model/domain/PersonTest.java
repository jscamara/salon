/**
 * 
 */
package br.com.beautysalon.model.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Jonathan
 *
 */
public class PersonTest {

	private Person person;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.person = new Person();
	}

	/**
	 * Test method for {@link br.com.beautysalon.model.domain.Person#validate()}.
	 */
	@Test
	public void testValidate() {
		this.person = this.getValidPerson();
		assertTrue(this.person.validate());
	}

	private Person getValidPerson(){
		Person person = new Person();
		person.setName("Jonathan da Silva Camara");
		person.setAdress(new AdressTest().getValidAdress());
		person.setCpf(34178440888L);
		person.setRg("428095604");
		List<Phone> phones = new ArrayList<Phone>();
		phones.add(new PhoneTest().getValidCellPhone());
		phones.add(new PhoneTest().getValidHomePhone());
		person.setPhones(phones);
		person.setPhoto("C:\\Images\\");
		person.setUser(new User());
		return person;
	}
}
