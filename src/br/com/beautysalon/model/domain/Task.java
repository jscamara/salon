/**
 * 
 */
package br.com.beautysalon.model.domain;

import br.com.beautysalon.util.BeautySalonUtil;

/**
 * Representa uma tarefa prestada pelo profissional ao cliente.
 * Ex.: Corte de cabelo, hidratação, pintura das unhas.
 * @author Jonathan
 *
 */
public class Task {
	private long id;
	private String name;
	private String description;
	private double time;
	private Specialty specialty;
	private boolean active;

	/**
	 * Valida se o serviço é válido
	 * @return true - se o serviço for válido<br>
	 * false - se o serviço for inválido
	 */
	public boolean validate(){
		if(BeautySalonUtil.isEmpty(this.name)){
			return false;
		}else if(this.time <= 0){
			return false;
		}else if(this.specialty == null){
			return false;
		}else{
			return true;
		}
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
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
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