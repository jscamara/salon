/**
 * 
 */
package br.com.beautysalon.model.domain;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 * Representa o acesso de uma pessoa ao sistema
 * @author Jonathan
 */

@Entity
public class User {
	@Id
	private String email;
	private String password;
	private String secretAnswer;
	@Enumerated
	private Authorization authorization;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecretAnswer() {
		return secretAnswer;
	}
	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}
	public Authorization getAuthorization() {
		return authorization;
	}
	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}
}