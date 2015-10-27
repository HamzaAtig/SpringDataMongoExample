package com.hat.examples.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "person")
public class Person {

	@Id
	private Long personId;

	private String name;

	private int age;

	private List<Address> addresses = new ArrayList<Address>();

	private List<Car> cars = new ArrayList<Car>();

	public Person() {
	}

	@PersistenceConstructor
	public Person(Long personId, String name, int age, List<Address> addresses) {
		super();
		this.personId = personId;
		this.name = name;
		this.age = age;
		this.addresses = addresses;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", age="
				+ age + ", addresses=" + addresses + ", cars=" + cars + "]";
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
