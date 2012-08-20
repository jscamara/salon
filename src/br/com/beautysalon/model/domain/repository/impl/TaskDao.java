/**
 * 
 */
package br.com.beautysalon.model.domain.repository.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.beautysalon.infra.HibernateFactory;
import br.com.beautysalon.model.domain.Task;
import br.com.beautysalon.model.domain.repository.TaskRepository;
import br.com.caelum.vraptor.ioc.Component;

/**
 * Implementação Hibernate do repositório de tarefas.
 * @author Jonathan
 *
 */
@Component
public class TaskDao implements TaskRepository{
	private Session session;

	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.TaskRepository#add(br.com.beautysalon.model.domain.Task)
	 */
	@Override
	public boolean add(Task task) {
		Transaction transaction = null;
		try {
			this.session = HibernateFactory.getSession().openSession();
			transaction = this.session.beginTransaction();
			this.session.save(task);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally{
			if(this.session != null){
				this.session.close();
			}
		}
	}

	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.TaskRepository#disable(long)
	 */
	@Override
	public void disable(long id) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.TaskRepository#list()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Task> list() {
		try {
			this.session = HibernateFactory.getSession().openSession();
			return this.session.createCriteria(Task.class).list();
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
	 * @see br.com.beautysalon.model.domain.repository.TaskRepository#listActives()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Task> listActives() {
		try {
			this.session = HibernateFactory.getSession().openSession();
			return this.session.createCriteria(Task.class).add(Restrictions.eq("active", true)).list();
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
	 * @see br.com.beautysalon.model.domain.repository.TaskRepository#getById(long)
	 */
	@Override
	public Task getById(long id) {
		try {
			this.session = HibernateFactory.getSession().openSession();
			return (Task) this.session.load(Task.class, id);
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