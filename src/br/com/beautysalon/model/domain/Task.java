/**
 * 
 */
package br.com.beautysalon.model.domain;

import static br.com.beautysalon.util.BeautySalonUtil.isEmpty;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

/**
 * Representa uma tarefa prestada pelo profissional ao cliente.
 * Ex.: Corte de cabelo, hidratação, pintura das unhas.
 * @author Jonathan
 *
 */
@Entity
public class Task {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String description;
	private int time;
	@Enumerated
	private Specialty specialty;
	private boolean active;

	/**
	 * Valida se o serviço é válido
	 * @param validator
	 */
	public void validate(Validator validator){
		validator.checking(new Validations() {
			{
				if(this.that(!isEmpty(getName()), "validation", "validation.required", i18n("task.name"))) {
					this.that(getName().length() <= 200, "validation", "validation.maxLength", i18n("task.name"), 200);
				}
				if(this.that(!isEmpty(getDescription()), "validation", "validation.required", i18n("task.description"))) {
					this.that(getDescription().length() <= 1000, "validation", "validation.maxLength", i18n("task.description"), 1000);
				}
				if(this.that(getTime() > 0, "validation", "validation.required", i18n("task.time")));
			}
		});
	}
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public Specialty getSpecialty() {
		return specialty;
	}
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}