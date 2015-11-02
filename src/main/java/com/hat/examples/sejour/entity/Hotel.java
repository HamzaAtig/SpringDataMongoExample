package com.hat.examples.sejour.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@TypeAlias(value = "hotel")
@Document(collection="hotel")
public class Hotel {

	@Id
	private Long hotelId; 
	
	private String name; 
	
	private Integer nombreEtoil ;
	
	private Integer nombreDeNuit;
	
	private double prix;
	
	
	public Hotel() {
		super();
	}

	@PersistenceConstructor
	public Hotel(Long hotelId, String name, Integer nombreEtoil,
			Integer nombreDeNuit, double prix) {
		super();
		this.hotelId = hotelId;
		this.name = name;
		this.nombreEtoil = nombreEtoil;
		this.nombreDeNuit = nombreDeNuit;
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", name=" + name
				+ ", nombreEtoil=" + nombreEtoil + ", nombreDeNuit="
				+ nombreDeNuit + ", prix=" + prix + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNombreEtoil() {
		return nombreEtoil;
	}

	public void setNombreEtoil(Integer nombreEtoil) {
		this.nombreEtoil = nombreEtoil;
	}

	public Integer getNombreDeNuit() {
		return nombreDeNuit;
	}

	public void setNombreDeNuit(Integer nombreDeNuit) {
		this.nombreDeNuit = nombreDeNuit;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	} 
	
	
}
