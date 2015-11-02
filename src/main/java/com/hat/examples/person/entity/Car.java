package com.hat.examples.person.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "car")
public class Car {

	@Id
	private long carId;

	private String brand;

	private String serial;

	private String color;

	public Car() {
		super();
	}
	
	public Car(String brand, String serial, String color) {
		super();
		this.brand = brand;
		this.serial = serial;
		this.color = color;
	}
	
	@PersistenceConstructor
	public Car(long carId, String brand, String serial, String color) {
		super();
		this.carId = carId;
		this.brand = brand;
		this.serial = serial;
		this.color = color;
	}

	
	
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", brand=" + brand + ", serial="
				+ serial + ", color=" + color + "]";
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
