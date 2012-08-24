/**
 * 
 */
package br.com.beautysalon.model.domain;

import static br.com.beautysalon.util.BeautySalonUtil.isEmpty;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.beautysalon.util.BeautySalonUtil;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

/**
 * Representa uma pessoa
 * @author Jonathan
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("P")
@DiscriminatorColumn(name="subclass", discriminatorType=DiscriminatorType.CHAR)
public class Person {
	@Id
	private long cpf;
	private String name;
	private String rg;
	private String photo;
	@OneToOne
	private Adress adress;
	@OneToMany
	private List<Phone> phones;
	@OneToOne
	private User user;
	@ManyToOne
	private Salon salon;

	/**
	 * Valida se os dados de uma pessoa são válidos
	 * @return true - se os dados da pessoa forem válidos <br>
	 * false - se os dados da pessoa forem inválidos
	 */
	public void validate(final Validator validator){
		validator.checking(new Validations() {
			{
				if(this.that(!isEmpty(getName()), "validation", "validation.required", i18n("person.name"))) {
					this.that(getName().length() <= 200, "validation", "validation.maxLength", i18n("person.name"), 200);
				}
				if(this.that(BeautySalonUtil.isValidCpf(getCpf()), "validation", "validation.invalid", i18n("person.cpf")));
				
				if(this.that(!isEmpty(getRg()), "validation", "validation.maxLength", i18n("person.rg")));

				if(this.that(!isEmpty(getPhoto()), "validation", "validation.required", i18n("person.photo")));
				
				getAdress().validate(validator);
				
				for(Phone phone : getPhones()){
					phone.validate(validator);
				}
			}
		});
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}
}