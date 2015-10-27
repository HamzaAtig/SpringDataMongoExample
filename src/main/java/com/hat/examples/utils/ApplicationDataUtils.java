package com.hat.examples.utils;

import java.util.ArrayList;
import java.util.List;

import com.hat.examples.entity.Address;
import com.hat.examples.entity.Car;

public class ApplicationDataUtils {

	public static List<Car> getCars() {
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car("BMW", "NY8758 OL 01", "RED"));
		cars.add(new Car("Renault", "Tadhamen OL 55", "GREEN"));
		return cars;
	}
	
	public static List<Address> getAdresses(){
		Address address = new Address(1, "221b Baker Street", "London NW1",
				"London", 12345l);
		
		List<Address> adresses = new ArrayList<Address>();
		adresses.add(address);
		
		return adresses;
	}
}
