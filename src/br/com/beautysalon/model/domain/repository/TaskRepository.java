/**
 * 
 */
package br.com.beautysalon.model.domain.repository;

import java.util.List;

import br.com.beautysalon.model.domain.Task;

/**
 * Repositório de uma {@link Task}
 * @author Jonathan
 *
 */
public interface TaskRepository {
	/**
	 * Adiciona uma tarefa 
	 * @param task - Tarefa a ser adicionada
	 */
	void add(Task task);
	
	/**
	 * Desativa uma tarefa
	 * @param id
	 */
	void disable(long id);
	
	/**
	 * Lista todas as tarefas
	 * @return
	 */
	List<Task> list();
	
	/**
	 * Lita todas as tarefas ativas
	 * @return
	 */
	List<Task> listActives();
	
	/**
	 * Recupera uma tarefa pelo id
	 * @param id - id da tarefa
	 * @return
	 */
	Task getById(long id);
}