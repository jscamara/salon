/**
 * 
 */
package br.com.beautysalon.model.domain.repository;

import java.util.List;

import br.com.beautysalon.model.domain.User;

/**
 * Representa um reposit�rio de Usu�rios
 * @author Jonathan
 */
public interface UserRepository {
	/**
	 * Encontra um usu�rio pelo login e senha
	 * @param login
	 * @param password
	 * @return
	 */
	User find(String login, String password);
	
	/**
	 * Adiciona um usu�rio na base
	 * @param user
	 * @return
	 */
	boolean add(User user);
	
	/**
	 * Atualiza os dados de um usu�rio
	 * @param user
	 * @return
	 */
	boolean update(User user);
	
	/**
	 * Sincroniza o usu�rio com a base de dados
	 * @param user
	 */
	void refresh(User user);

	/**
	 * Verifica se j� existe um usu�rio com o login cadastrado
	 * @param login
	 * @return
	 */
	boolean containsUserWithLogin(String login);
	
	/**
	 * Lista todos os usu�rios cadastrados
	 * @return
	 */
	List<User> list();
}