/**
 * 
 */
package br.com.beautysalon.model.domain.repository;

import br.com.beautysalon.model.domain.Salon;

/**
 * Repositório de um {@link Salon}
 * @author Jonathan
 *
 */
public interface SalonRepository {
	/**
	 * Adiciona um Salão
	 * @param salon
	 */
	public void add(Salon salon);
}
