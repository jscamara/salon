package br.com.beautysalon.i18n;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

/**
 * Classe encapsula arquivo de internacionalização utilizado pela aplicação
 * 
 * @author Nykolas Lima
 * @since 23/10/2011
 */
public class Bundle extends ResourceBundle {
	private static final String	TEXT_ATTRIBUTE_NAME	= "bundle";
	private static final String	TEXT_BASE_NAME		= "messages";
	
	private Bundle(Locale locale) {
		this.setLocale(locale);
	}
	
	/**
	 * Seta Bundle no request recebido
	 * 
	 * @param request
	 */
	public static void setFor(HttpServletRequest request) {
		if(request.getSession().getAttribute(Bundle.TEXT_ATTRIBUTE_NAME) == null) {
			request.getSession().setAttribute(Bundle.TEXT_ATTRIBUTE_NAME, new Bundle(request.getLocale()));
		}
	}
	
	/**
	 * Retorna o Bundle existente na sessão
	 * 
	 * @param request
	 * @return Bundle existente na sessão
	 */
	public static Bundle getCurrentInstance(HttpServletRequest request) {
		return (Bundle) request.getSession().getAttribute(Bundle.TEXT_ATTRIBUTE_NAME);
	}
	
	/**
	 * Altera o local do Bundle
	 * 
	 * @param locale
	 */
	public void setLocale(Locale locale) {
		if(this.parent == null || !this.parent.getLocale().equals(locale)) {
			this.setParent(getBundle(Bundle.TEXT_BASE_NAME, locale));
		}
	}
	
	@Override
	public Enumeration<String> getKeys() {
		return this.parent.getKeys();
	}
	
	@Override
	protected Object handleGetObject(String key) {
		return this.parent.getObject(key);
	}
}
