package com.hat.examples.sejour.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@TypeAlias(value = "sejour")
@Document(collection="sejour")
public class Sejour {

	@Id
	private Long sejourId;

	private Integer nombreDeNuit;

	private Integer nombreDeJour;

	private Double prix;

	private List<Hotel> hotels;

	private List<Vol> vols;

	public Sejour() {
		super();
		
	}
	
	@PersistenceConstructor
	public Sejour(Long sejourId, Integer nombreDeNuit, Integer nombreDeJour,
			Double prix, List<Hotel> hotels, List<Vol> vols) {
		super();
		this.sejourId = sejourId;
		this.nombreDeNuit = nombreDeNuit;
		this.nombreDeJour = nombreDeJour;
		this.prix = prix;
		this.hotels = hotels;
		this.vols = vols;
	}
	
	@Override
	public String toString() {
		return "Sejour [sejourId=" + sejourId + ", nombreDeNuit="
				+ nombreDeNuit + ", nombreDeJour=" + nombreDeJour + ", prix="
				+ prix + ", hotels=" + hotels + ", vols=" + vols + "]";
	}

	public Long getSejourId() {
		return sejourId;
	}

	public void setSejourId(Long sejourId) {
		this.sejourId = sejourId;
	}

	public Integer getNombreDeJour() {
		return nombreDeJour;
	}

	public void setNombreDeJour(Integer nombreDeJour) {
		this.nombreDeJour = nombreDeJour;
	}

	public Integer getNombreDeNuit() {
		return nombreDeNuit;
	}

	public void setNombreDeNuit(Integer nombreDeNuit) {
		this.nombreDeNuit = nombreDeNuit;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public List<Vol> getVols() {
		return vols;
	}

	public void setVols(List<Vol> vols) {
		this.vols = vols;
	}
}
