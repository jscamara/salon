package br.com.beautysalon.model.domain;

public enum Specialty {
	HAIR_STYLIST("Cabelereira"), MANICURE_PEDICURE("Manicure");

	private String name;

	private Specialty(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
