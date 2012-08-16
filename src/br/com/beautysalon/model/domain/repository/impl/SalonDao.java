/**
 * 
 */
package br.com.beautysalon.model.domain.repository.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.beautysalon.infra.HibernateFactory;
import br.com.beautysalon.model.domain.Salon;
import br.com.beautysalon.model.domain.repository.SalonRepository;

/**
 * Implementação Hibernate do Repositório de um Salão
 * @author Jonathan
 *
 */
public class SalonDao implements SalonRepository {
	private Session session;
	
	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.SalonRepository#add(br.com.beautysalon.model.domain.Salon)
	 */
	@Override
	public void add(Salon salon) {
		Transaction transaction = null;
		try {
			this.session = HibernateFactory.getSession().openSession();
			transaction = this.session.beginTransaction();
			transaction.begin();
			this.session.save(salon);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally{
			if(this.session != null){
				this.session.close();
			}
		}
	}
}