/**
 * 
 */
package br.com.beautysalon.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Representa a agenda de um profissional.
 * @author Jonathan
 */

@Entity
public class Agenda {
	@Id
	private int year;
	
	@OneToMany
	private List<Appointment> appointments;

	@ManyToOne
	private Professional professional;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public Professional getProfessional() {
		return professional;
	}
	public void setProfessional(Professional professional) {
		this.professional = professional;
	}
}
