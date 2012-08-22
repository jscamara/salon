/**
 * 
 */
package br.com.beautysalon.model.domain.repository;

import java.util.List;

import br.com.beautysalon.model.domain.Client;

/**
 * Reposit�rio de um {@link Client}
 * @author Jonathan
 *
 */
public interface ClientRepository {
	/**
	 * Adiciona um cliente
	 * @param client - cliente que ser� adicionado
	 */
	boolean add(Client client);
	
	/**
	 * Atualiza os dados de um cliente
	 * @param client - cliente que ter� seus dados atualizados
	 */
	boolean update(Client client);

	/**
	 * Lista todos os clientes do sal�o
	 * @return
	 */
	List<Client> list();
	
	/**
	 * Retorna um cliente pelo seu id
	 * @param id - id do cliente
	 * @return
	 */
	Client getById(long id);
}