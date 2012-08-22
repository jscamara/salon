/**
 * 
 */
package br.com.beautysalon.model.domain.repository;

import java.util.List;

import br.com.beautysalon.model.domain.User;

/**
 * Representa um repositório de Usuários
 * @author Jonathan
 */
public interface UserRepository {
	/**
	 * Encontra um usuário pelo login e senha
	 * @param login
	 * @param password
	 * @return
	 */
	User find(String login, String password);
	
	/**
	 * Adiciona um usuário na base
	 * @param user
	 * @return
	 */
	boolean add(User user);
	
	/**
	 * Atualiza os dados de um usuário
	 * @param user
	 * @return
	 */
	boolean update(User user);
	
	/**
	 * Sincroniza o usuário com a base de dados
	 * @param user
	 */
	void refresh(User user);

	/**
	 * Verifica se já existe um usuário com o login cadastrado
	 * @param login
	 * @return
	 */
	boolean containsUserWithLogin(String login);
	
	/**
	 * Lista todos os usuários cadastrados
	 * @return
	 */
	List<User> list();
}