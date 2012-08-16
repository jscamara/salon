/**
 * 
 */
package br.com.beautysalon.model.domain.repository;

import java.util.List;

import br.com.beautysalon.model.domain.Client;

/**
 * Repositório de um {@link Client}
 * @author Jonathan
 *
 */
public interface ClientRepository {
	/**
	 * Adiciona um cliente
	 * @param client - cliente que será adicionado
	 */
	void add(Client client);
	
	/**
	 * Atualiza os dados de um cliente
	 * @param client - cliente que terá seus dados atualizados
	 */
	void update(Client client);

	/**
	 * Lista todos os clientes do salão
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