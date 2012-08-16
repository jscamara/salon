package br.com.beautysalon.model.domain;

public enum Specialty {
	HAIR_STYLIST("Cabelereiro"), MANICURE_PEDICURE("Manicure");

	private String name;

	private Specialty(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
