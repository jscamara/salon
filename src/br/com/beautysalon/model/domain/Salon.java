/**
 * 
 */
package br.com.beautysalon.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Representa uma Salão
 * @author Jonathan
 *
 */
@Entity
public class Salon {
	@Id
	@GeneratedValue
	private long id;
	private String name;

	@OneToOne
	private Adress adress;

	@OneToMany(cascade=CascadeType.ALL)
	List<Phone> phones;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Professional> professionals;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Client> clients;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public List<Professional> getProfessionals() {
		return professionals;
	}
	public void setProfessionals(List<Professional> professionals) {
		this.professionals = professionals;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
}