/**
 * 
 */
package br.com.beautysalon.model.domain.repository.impl;

import org.hibernate.Session;

import br.com.beautysalon.model.domain.Salon;
import br.com.beautysalon.model.domain.repository.SalonRepository;

/**
 * Implementação Hibernate do Repositório de um Salão
 * @author Jonathan
 *
 */
public class SalonDao implements SalonRepository {
	private Session session;
	
	public SalonDao(Session session){
		this.session = session;
	}
	
	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.SalonRepository#add(br.com.beautysalon.model.domain.Salon)
	 */
	@Override
	public void add(Salon salon) {
		this.session.save(salon);
	}
}