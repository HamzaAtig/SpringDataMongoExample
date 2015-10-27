package com.hat.examples.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hat.examples.entity.Person;
import com.hat.examples.repo.PersonRepo;



public class Application {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new ClassPathResource("spring-config.xml").getPath());
		PersonRepo personRepo = context.getBean(PersonRepo.class);
		//AddressRepo addressRepo = context.getBean(AddressRepo.class);
		MongoOperations  mongo = (MongoOperations) context.getBean("mongoTemplate");

//		List<Car> cars = new ArrayList<Car>();
//		cars.add(new Car("BMW", "NY8758 OL 01", "RED"));
//		cars.add(new Car("Renault", "Tadhamen OL 55", "GREEN"));
//		 Person personAchilles = new Person();
//		 personAchilles.setPersonId(1l);
//		 personAchilles.setName("Olfa");
//		 personAchilles.setAge(28);
//		 personAchilles.setCars(cars);
//		 personRepo.save(personAchilles);
//		 Person personHektor = new Person();
//		 personHektor.setPersonId(2l);
//		 personHektor.setName("Hamza");
//		 personHektor.setAge(50);
//		
//		 Address address = new Address(1, "221b Baker Street", "London NW1", "London", 12345l);
//		 List<Address> addresses = personHektor.getAddresses();
//		 addresses.add(address);
//		 personAchilles.setAddresses(addresses);
		
//		 addressRepo.save(address);
//		 personRepo.save(personHektor);
//		
//		 Iterable<Person> personList = personRepo.findAll();
//		 System.out.println("Person List : ");
//		 for (Person person : personList) {
//		 System.out.println(person);
//		 }
		
		// System.out.println("Person with Id 1 is " + personRepo.searchByName("Hektor"));

//		 Iterable<Person> personList = personRepo.searchByStateName("London");
//		
//		 for (Person person : personList) {
//		 System.out.println(person);
//		 }

//		Iterable<Address> addresses = addressRepo.searchByStateName("London");
//		for (Address item : addresses) {
//			System.out.println(item);
//		}
//		ArrayList<Integer> ageList = new ArrayList<Integer>();
//		ageList.add(28);
//		ageList.add(50);
//		Query query = new Query();
//		query.addCriteria(Criteria.where("age").in(ageList));
//		Iterable<Person> personList = mongo.find(query, Person.class);
//		
//		Long ageCount = mongo.count(query, Person.class);
//		System.out.println("ageCount : "+ageCount);
//
//		for (Person person : personList) {
//			System.out.println(person);
//		}
		
		Query query = new Query();
		query.addCriteria(Criteria.where("cars.brand").is("BMW"));
		
		//Update 
		Update update = new Update();
		update.set("name", "hamza");
		mongo.updateFirst(query, update, Person.class);
		
//		Long ageCount = mongo.count(query, Person.class);
//		System.out.println("brand count : "+ageCount);

		//find 
		Iterable<Person> personList = mongo.find(query, Person.class);
		
		for (Person person : personList) {
			System.out.println(person);
		}
		
		context.close();

	}
}
