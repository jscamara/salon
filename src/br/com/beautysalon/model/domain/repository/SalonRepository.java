/**
 * 
 */
package br.com.beautysalon.model.domain.repository;

import br.com.beautysalon.model.domain.Salon;

/**
 * Reposit�rio de um {@link Salon}
 * @author Jonathan
 *
 */
public interface SalonRepository {
	/**
	 * Adiciona um Sal�o
	 * @param salon
	 */
	public void add(Salon salon);
}
