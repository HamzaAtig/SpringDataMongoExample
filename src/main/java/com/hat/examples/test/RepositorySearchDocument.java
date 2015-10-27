package com.hat.examples.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.hat.examples.entity.Person;
import com.hat.examples.repo.PersonRepo;

public class RepositorySearchDocument {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new ClassPathResource("spring-config.xml").getPath());
		PersonRepo personRepo = context.getBean(PersonRepo.class);

		Iterable<Person> personList = personRepo.searchByStateName("London");

		for (Person person : personList) {
			System.out.println(person);
		}
		
		personList = personRepo.searchByName("Hamza");
		for (Person person : personList) {
			System.out.println(person);
		}
		
		context.close();

	}
}
