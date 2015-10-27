package com.hat.examples.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.hat.examples.entity.Person;
import com.hat.examples.repo.PersonRepo;
import com.hat.examples.utils.ApplicationDataUtils;

public class InsertDocuments {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new ClassPathResource("spring-config.xml").getPath());
		PersonRepo personRepo = context.getBean(PersonRepo.class);

		//create person1
		Person person1 = new Person();
		person1.setPersonId(1l);
		person1.setName("Olfa");
		person1.setAge(28);
		person1.setCars(ApplicationDataUtils.getCars());
		//save person1
		personRepo.save(person1);

		//create person2
		Person person2 = new Person();
		person2.setPersonId(2l);
		person2.setName("Hamza");
		person2.setAge(50);
		person2.setAddresses(ApplicationDataUtils.getAdresses());
		//save person2
		personRepo.save(person2);

		//findAll person
		Iterable<Person> personList = personRepo.findAll();
		System.out.println("Person List : ");
		for (Person person : personList) {
			System.out.println(person);
		}

		//search by name 
		personList = personRepo.searchByName("Hamza");

		for (Person person : personList) {
			System.out.println(person);
		}

		context.close();

	}
}
