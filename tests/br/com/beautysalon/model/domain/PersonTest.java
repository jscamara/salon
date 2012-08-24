/**
 * 
 */
package br.com.beautysalon.model.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.util.test.MockValidator;
import static br.com.beautysalon.util.BeautySalonUtilTest.bigWord;

/**
 * @author Jonathan
 *
 */
public class PersonTest {

	private MockValidator validator;
	private Person person;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.validator = new MockValidator();
		this.person = this.getValidPerson();
	}

	/**
	 * Test method for {@link br.com.beautysalon.model.domain.Person#validate()}.
	 */
	@Test
	public void validPersonShouldBeValid() {
		this.person.validate(this.validator);
		assertFalse(this.validator.hasErrors());
	}

	@Test
	public void nameShouldBeRequired(){
		this.validator = new MockValidator();
		this.person.setName(null);
		this.person.validate(this.validator);
		assertTrue(this.validator.hasErrors());
		
		this.validator = new MockValidator();
		this.person.setName("");
		this.person.validate(this.validator);
		assertTrue(this.validator.hasErrors());
	}
	
	@Test
	public void nameShouldNotBeGreaterThan200(){
		this.validator = new MockValidator();
		this.person.setName(bigWord(201));
		this.person.validate(this.validator);
		assertTrue(this.validator.hasErrors());
	}
	
	@Test
	public void cpfShouldBeValid(){
		this.validator = new MockValidator();
		this.person.setCpf(123L);
		this.person.validate(this.validator);
		assertTrue(this.validator.hasErrors());
		
		this.validator = new MockValidator();
		this.person.setCpf(34178440889L);
		this.person.validate(this.validator);
		assertTrue(this.validator.hasErrors());
	}
	
	@Test
	public void rgShouldBeRequired(){
		this.validator = new MockValidator();
		this.person.setRg(null);
		this.person.validate(this.validator);
		assertTrue(this.validator.hasErrors());
		
		this.validator = new MockValidator();
		this.person.setRg("");
		this.person.validate(this.validator);
		assertTrue(this.validator.hasErrors());
	}
	
	public void photoShouldBeRequired(){
		this.validator = new MockValidator();
		this.person.setPhoto(null);
		this.person.validate(this.validator);
		assertTrue(this.validator.hasErrors());
		
		this.validator = new MockValidator();
		this.person.setPhoto("");
		this.person.validate(this.validator);
		assertTrue(this.validator.hasErrors());
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