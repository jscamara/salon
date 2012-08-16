/**
 * 
 */
package br.com.beautysalon.model.domain.repository;

import java.util.List;

import br.com.beautysalon.model.domain.Professional;

/**
 * Repositório de um {@link Professional}
 * @author Jonathan
 *
 */
public interface ProfessionalRepository {
	/**
	 * Adiciona um novo profissional
	 * @param professional
	 */
	void add(Professional professional);
	
	/**
	 * Atualiza os dados de um profissional
	 * @param professional
	 */
	void update(Professional professional);
	
	/**
	 * Lista todos os profissionais
	 * @return
	 */
	List<Professional> list();
	
	/**
	 * Retorna um profissional pelo seu id
	 * @param id - id do profissional
	 * @return
	 */
	Professional getById(long id);
}
