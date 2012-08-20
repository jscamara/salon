/**
 * 
 */
package br.com.beautysalon.model.domain;

import static br.com.beautysalon.util.BeautySalonUtil.isEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

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
	public void validate(Validator validator){
		validator.checking(new Validations() {
			{
				if(this.that(!isEmpty(getStreet()), "validation", "validation.required", i18n("adress.street"))) {
					this.that(getStreet().length() <= 200, "validation", "validation.maxLength", i18n("adress.street"), 200);
				}

				if(this.that(getNumber() > 0, "validation", "validation.required", i18n("adress.number")));
				
				if(this.that(!isEmpty(getNeighborhood()), "validation", "validation.required", i18n("adress.neighborhood"))){
					this.that(getNeighborhood().length() <= 100, "validation", "validation.maxLength", i18n("adress.neighborhood"), 100);
				}
		
				if(this.that(!isEmpty(getCity()), "validation", "validation.required", i18n("adress.city"))){
					this.that(getCity().length() <= 50, "validation", "validation.maxLength", i18n("adress.city"), 50);
				}
				
				if(this.that(!isEmpty(getState()), "validation", "validation.required", i18n("adress.state"))){
					this.that(getCity().length() != 2, "validation", "validation.maxLength", i18n("adress.state"), 2);
				}
				
				if(this.that(String.valueOf(getCep()).length() != 8, "validation", "validation.required", i18n("adress.cep")));
			}
		});
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