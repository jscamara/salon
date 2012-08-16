/**
 * 
 */
package br.com.beautysalon.infra;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * F�brica de sess�es do hibernate
 * @author Jonathan
 *
 */
public class HibernateFactory {
	private static SessionFactory session;
	
	@SuppressWarnings("deprecation")
	public static SessionFactory getSession(){
		session = new Configuration().configure().buildSessionFactory(); 
		return session;
	}
}
