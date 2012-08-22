/**
 * 
 */
package br.com.beautysalon.model.domain.repository.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.beautysalon.infra.HibernateFactory;
import br.com.beautysalon.model.domain.Client;
import br.com.beautysalon.model.domain.repository.ClientRepository;
import br.com.caelum.vraptor.ioc.Component;

/**
 * Implementação Hibernate de um repositório de clientes.
 * @author Jonathan
 *
 */
@Component
public class ClientDao implements ClientRepository {

	private Session session;
	
	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.ClientRepository#add(br.com.beautysalon.model.domain.Client)
	 */
	@Override
	public boolean add(Client client) {
		Transaction transaction = null;
		try {
			this.session = HibernateFactory.getSession().openSession();
			transaction = this.session.beginTransaction();
			transaction.begin();
			this.session.save(client);
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
	 * @see br.com.beautysalon.model.domain.repository.ClientRepository#update(br.com.beautysalon.model.domain.Client)
	 */
	@Override
	public boolean update(Client client) {
		Transaction transaction = null;
		try {
			this.session = HibernateFactory.getSession().openSession();
			transaction = this.session.beginTransaction();
			transaction.begin();
			this.session.update(client);
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
	 * @see br.com.beautysalon.model.domain.repository.ClientRepository#list()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> list() {
		try {
			this.session = HibernateFactory.getSession().openSession();
			return this.session.createCriteria(Client.class).list();
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
	 * @see br.com.beautysalon.model.domain.repository.ClientRepository#getById(long)
	 */
	@Override
	public Client getById(long id) {
		try {
			this.session = HibernateFactory.getSession().openSession();
			return (Client) this.session.load(Client.class, id);
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