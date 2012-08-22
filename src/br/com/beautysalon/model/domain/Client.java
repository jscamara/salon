/**
 * 
 */
package br.com.beautysalon.model.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Representa um cliente do salão
 * @author Jonathan
 *
 */
@Entity
@DiscriminatorValue("C")
public class Client extends Person {

}