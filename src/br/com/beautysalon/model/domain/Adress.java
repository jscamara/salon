/**
 * 
 */
package br.com.beautysalon.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.beautysalon.util.BeautySalonUtil;

/**
 * Representa o endereço de uma Pessoa;
 * @author Jonathan
 *
 */
@Entity
public class Adress {
	@Id
	@GeneratedValue
	private long id;
	private String street;
	private int number;
	private String neighborhood;
	private String city;
	private String state;
	private String complement;
	private int cep;

	/**
	 * Valida um endereço
	 * @return true - se os dados do endereço foram válidos<br>
	 * false - se os dados forem inválidos
	 */
	public boolean validate(){
		if(BeautySalonUtil.isEmpty(this.street)){
			return false;
		}else if(this.number <= 0){
			return false;
		}else if(BeautySalonUtil.isEmpty(this.neighborhood)){
			return false;
		}else if(BeautySalonUtil.isEmpty(this.city)){
			return false;
		}else if(BeautySalonUtil.isEmpty(this.state)){
			return false;
		}else if(this.cep <= 0){
			return false;
		}else{
			return true;
		}
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
}