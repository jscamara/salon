/**
 * 
 */
package br.com.beautysalon.model.domain;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.beautysalon.util.BeautySalonUtil;

/**
 * Representa uma pessoa
 * @author Jonathan
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
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

	/**
	 * Valida se os dados de uma pessoa são válidos
	 * @return true - se os dados da pessoa forem válidos <br>
	 * false - se os dados da pessoa forem inválidos
	 */
	public boolean validate(){
		if(BeautySalonUtil.isEmpty(this.name)){
			return false;
		}else if(!BeautySalonUtil.isValidCpf(this.cpf)){
			return false;
		}else if(BeautySalonUtil.isEmpty(this.photo)){
			return false;
		}else if(!this.adress.validate()){
			return false;
		}else if(this.phones != null){
			for(Phone phone : phones){
				if(!phone.validate()){
					return false;
				}
			}
		}
		return true;
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
}