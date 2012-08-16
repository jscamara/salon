/**
 * 
 */
package br.com.beautysalon.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
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
	List<Appointment> appointments;

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
}
