/**
 * 
 */
package br.com.beautysalon.util;

/**
 * Métodos úteis para todo o projeto
 * @author Jonathan
 *
 */
public class BeautySalonUtil {

	private BeautySalonUtil(){

	}
	/**
	 * Verifica se o texto é nulo ou vazio
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(String value){
		return (value == null || value.trim().equals("")) ? true : false;
	}

	/**
	 * Verifica se o texto possui o tamanho máximo permitido
	 * @param text
	 * @param maxLength
	 * @return
	 */
	public static boolean checkMaxLength(String text, int maxLength){
		return text.length() <= maxLength ? true : false;
	}

	/**
	 * Verifica se o cpf é válido
	 * @param cpf
	 * @return true - se o cpf for válido<br>
	 * false - se o cpf for inválido
	 */
	public static boolean isValidCpf(long cpf){
		String CPF = String.valueOf(cpf);

		char dig10, dig11;
		int sm, i, r, num, peso;

		sm = 0;
		peso = 10;
		for (i=0; i<9; i++) {             
			num = (int)(CPF.charAt(i) - 48);
			sm = sm + (num * peso);
			peso = peso - 1;
		}

		r = 11 - (sm % 11);
		if ((r == 10) || (r == 11)){
			dig10 = '0';
		}else{
			dig10 = (char)(r + 48);
		}

		sm = 0;
		peso = 11;
		for(i=0; i<10; i++) {
			num = (int)(CPF.charAt(i) - 48);
			sm = sm + (num * peso);
			peso = peso - 1;
		}

		r = 11 - (sm % 11);
		if ((r == 10) || (r == 11)){
			dig11 = '0';
		}else{
			dig11 = (char)(r + 48);
		}

		if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))){
			return true;
		}else{
			return false;
		}
	}
}