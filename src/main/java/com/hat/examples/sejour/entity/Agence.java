package com.hat.examples.sejour.entity;

import java.util.List;

public class Agence {
	
	private String name ; 
	
	private List<Sejour> sejours;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Sejour> getSejours() {
		return sejours;
	}

	public void setSejours(List<Sejour> sejours) {
		this.sejours = sejours;
	} 

}
