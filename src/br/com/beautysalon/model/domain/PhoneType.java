/**
 * 
 */
package br.com.beautysalon.model.domain;

/**
 * Representa os tipos de telefones
 * @author Jonathan
 *
 */
public enum PhoneType {
	CELL("Celular"), HOME("Casa"), WORK("Trabalho"), OTHER("Outro");
	
	private String name;
	
	private PhoneType(String name) {
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}