/**
 * 
 */
package br.com.beautysalon.model.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


/**
 * Representa um profissional que trabalha no salão.
 * @author Jonathan
 *
 */
@Entity
@DiscriminatorValue("W")
public class Professional extends Person{
	private Specialty specialty;
	@OneToMany
	private Agenda agenda;
	
	public Specialty getSpecialty() {
		return specialty;
	}
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
}