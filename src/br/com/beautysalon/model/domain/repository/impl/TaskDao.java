/**
 * 
 */
package br.com.beautysalon.model.domain.repository.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
	private final Session session;

	public TaskDao(Session session){
		this.session = session;
	}
	
	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.TaskRepository#add(br.com.beautysalon.model.domain.Task)
	 */
	@Override
	public void add(Task task) {
		this.session.save(task);
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
			return this.session.createCriteria(Task.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
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
			return this.session.createCriteria(Task.class).add(Restrictions.eq("active", true)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.TaskRepository#getById(long)
	 */
	@Override
	public Task getById(long id) {
		try {
			return (Task) this.session.load(Task.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
}