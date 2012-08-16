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
public class TaskTest {

	private Task task;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.task = new Task();
	}

	/**
	 * Test method for {@link br.com.beautysalon.model.domain.Task#validate()}.
	 */
	@Test
	public void testValidate() {
		this.task = this.getValidService();
		assertTrue(this.task.validate());
	}

	/**
	 * Retorna um servi�o v�lido
	 * @return Servi�o v�lido
	 */
	private Task getValidService(){
		Task service = new Task();
		service.setId(1);
		service.setName("Hidrata��o");
		service.setDescription("Lavagem dos cabelos seguido de aplica��o de cremes hidratantes e massagem");
		service.setSpecialty(Specialty.HAIR_STYLIST);
		service.setTime(70);
		
		return service;
	}
}