/**
 * 
 */
package br.com.beautysalon.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;


/**
 * Representa um profissional que trabalha no salão.
 * @author Jonathan
 *
 */
@Entity
@DiscriminatorValue("W")
public class Professional extends Person{
	@Enumerated
	private Specialty specialty;
	
	@OneToMany(mappedBy="professional", cascade=CascadeType.ALL)
	private List<Agenda> agendas;
	
	public Specialty getSpecialty() {
		return specialty;
	}
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
	public List<Agenda> getAgendas() {
		return agendas;
	}
	public void setAgenda(List<Agenda> agendas) {
		this.agendas = agendas;
	}
}