/**
 * 
 */
package br.com.beautysalon.model.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.beautysalon.util.BeautySalonUtil;


/**
 * Representa um telefone de uma pessoa
 * @author Jonathan
 *
 */
@Entity
public class Phone {
	@Id
	@GeneratedValue
	private long id;
	private int ddd;
	private int number;
	private PhoneType type;

	/**
	 * Valida se o ddd e o telefone são válidos
	 * @return true - se o ddd e o telefone forem válidos <br>
	 * false - se o ddd e o telefone forem inválidos
	 */
	public boolean validate(){
		if(this.isValidDDD()){
			switch (this.type) {
				case CELL:
					return isValidCellNumber();
				default:
					return isValidNumber();
			}
		}else{
			return false;
		}
	}
	
	private boolean isValidDDD(){
		Pattern pattern = Pattern.compile("10|[1-9]{2}");
		Matcher matcher = pattern.matcher(String.valueOf(this.ddd));
		
		return matcher.find();
	}
	
	private boolean isValidCellNumber(){
		Pattern pattern;
		if(this.ddd == 11){
			if(BeautySalonUtil.checkMaxLength(String.valueOf(this.number), 9)){
				pattern = Pattern.compile("9[6-9][0-9]{7}");
			}else{
				return false;
			}
		}else{
			if(BeautySalonUtil.checkMaxLength(String.valueOf(this.number), 8)){
				pattern = Pattern.compile("[6-9][0-9]{7}");
			}else{
				return false;
			}
		}
		Matcher matcher = pattern.matcher(String.valueOf(this.number));
		
		return matcher.find();
	}
	
	private boolean isValidNumber(){
		if(BeautySalonUtil.checkMaxLength(String.valueOf(this.number), 8)){
			Pattern pattern = Pattern.compile("[2-5][0-9]{7}");
			Matcher matcher = pattern.matcher(String.valueOf(this.number));
			
			return matcher.find();
		}else{
			return false;
		}
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public PhoneType getType() {
		return type;
	}
	public void setType(PhoneType type) {
		this.type = type;
	}
}