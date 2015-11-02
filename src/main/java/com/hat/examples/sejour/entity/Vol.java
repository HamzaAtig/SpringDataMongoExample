package com.hat.examples.sejour.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@TypeAlias(value = "vol")
@Document(collection = "vol")
public class Vol {

	@Id
	private Long volId;

	private Date dateAller;

	private Date dateRetour;

	private double prix;

	public Vol() {
		super();

	}

	@PersistenceConstructor
	public Vol(Long volId, Date dateAller, Date dateRetour, double prix) {
		super();
		this.volId = volId;
		this.dateAller = dateAller;
		this.dateRetour = dateRetour;
		this.prix = prix;
	}

	public Long getVolId() {
		return volId;
	}

	public void setVolId(Long volId) {
		this.volId = volId;
	}

	public Date getDateAller() {
		return dateAller;
	}

	public void setDateAller(Date dateAller) {
		this.dateAller = dateAller;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
}
