/**
 * 
 */
package br.com.beautysalon.model.domain.repository.impl;

import java.util.List;

import org.hibernate.Session;

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
	
	public ProfessionalDao(Session session){
		this.session = session;
	}
	
	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.ProfessionalRepository#add(br.com.beautysalon.model.domain.Professional)
	 */
	@Override
	public void add(Professional professional) {
		this.session.save(professional);
	}

	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.ProfessionalRepository#update(br.com.beautysalon.model.domain.Professional)
	 */
	@Override
	public void update(Professional professional) {
		this.session.update(professional);
	}

	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.ProfessionalRepository#list()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Professional> list() {
		return this.session.createCriteria(Professional.class).list();
	}

	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.ProfessionalRepository#getById(long)
	 */
	@Override
	public Professional getById(long id) {
		return (Professional) this.session.load(Professional.class, id);
	}
}