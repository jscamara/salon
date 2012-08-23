/**
 * 
 */
package br.com.beautysalon.model.domain.repository.impl;

import java.util.List;

import org.hibernate.Session;

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
	
	public ClientDao(Session session){
		this.session = session;
	}
	
	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.ClientRepository#add(br.com.beautysalon.model.domain.Client)
	 */
	@Override
	public void add(Client client) {
		this.session.save(client);
	}

	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.ClientRepository#update(br.com.beautysalon.model.domain.Client)
	 */
	@Override
	public void update(Client client) {
		this.session.update(client);
	}

	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.ClientRepository#list()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> list() {
		return this.session.createCriteria(Client.class).list();
	}

	/* (non-Javadoc)
	 * @see br.com.beautysalon.model.domain.repository.ClientRepository#getById(long)
	 */
	@Override
	public Client getById(long id) {
		return (Client) this.session.load(Client.class, id);
	}
}