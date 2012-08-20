/**
 * 
 */
package br.com.beautysalon.model.domain.repository.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.beautysalon.infra.HibernateFactory;
import br.com.beautysalon.model.domain.Professional;
import br.com.beautysalon.model.domain.repository.ProfessionalRepository;
import br.com.caelum.vraptor.ioc.Component;

/**
 * Implementação Hibernate de um repositório de profissionais
 * @author Jonathan
 *
 */
@Component
public class ProfessionalDao implements ProfessionalRepository{
	
	private Session session;
	
	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.ProfessionalRepository#add(br.com.beautysalon.model.domain.Professional)
	 */
	@Override
	public boolean add(Professional professional) {
		Transaction transaction = null;
		try {
			this.session = HibernateFactory.getSession().openSession();
			transaction = this.session.beginTransaction();
			transaction.begin();
			this.session.save(professional);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			transaction.rollback();
			return false;
		} finally{
			if(this.session != null){
				this.session.close();
			}
		}
	}

	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.ProfessionalRepository#update(br.com.beautysalon.model.domain.Professional)
	 */
	@Override
	public boolean update(Professional professional) {
		Transaction transaction = null;
		try {
			this.session = HibernateFactory.getSession().openSession();
			transaction = this.session.beginTransaction();
			transaction.begin();
			this.session.update(professional);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			transaction.rollback();
			return false;
		} finally{
			if(this.session != null){
				this.session.close();
			}
		}
	}

	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.ProfessionalRepository#list()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Professional> list() {
		try {
			this.session = HibernateFactory.getSession().openSession();
			return this.session.createCriteria(Professional.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally{
			if(this.session != null){
				this.session.close();
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.ProfessionalRepository#getById(long)
	 */
	@Override
	public Professional getById(long id) {
		try {
			this.session = HibernateFactory.getSession().openSession();
			return (Professional) this.session.load(Professional.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally{
			if(this.session != null){
				this.session.close();
			}
		}
		return null;
	}
}