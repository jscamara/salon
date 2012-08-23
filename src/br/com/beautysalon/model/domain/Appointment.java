/**
 * 
 */
package br.com.beautysalon.model.domain;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Representa um compromisso marcado na agenda de um profissional.
 * @author Jonathan
 */
@Entity
public class Appointment {
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	private Client client;
	@OneToOne
	private Task task;
	private GregorianCalendar startAt;
	
	public Event asEvent(){
		Event event = new Event();
		
		StringBuilder builder = new StringBuilder();
		builder.append("Client : ").append(this.client.getName()).append(System.getProperty("line.separator"));
		builder.append("Task : ").append(this.task.getName()).append(System.getProperty("line.separator"));
		event.setTitle(builder.toString());
		event.setAllDay(false);
		
		Timestamp ts = new Timestamp(this.startAt.getTimeInMillis());
		event.setStart(ts.toString());
		return event;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public GregorianCalendar getStartAt() {
		return startAt;
	}
	public void setStartAt(GregorianCalendar startAt) {
		this.startAt = startAt;
	}
}