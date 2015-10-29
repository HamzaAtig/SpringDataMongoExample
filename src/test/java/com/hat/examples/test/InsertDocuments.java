package com.hat.examples.test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.hat.examples.entity.Person;
import com.hat.examples.repo.PersonRepo;
import com.hat.examples.utils.ApplicationDataUtils;

public class InsertDocuments {
	
	public final static Logger logger = Logger.getLogger(InsertDocuments.class);
	
	private ClassPathXmlApplicationContext context ;
	
	private PersonRepo personRepo; 
	
	@Before
	public void before() throws Exception {
	
		context = new ClassPathXmlApplicationContext(
				new ClassPathResource("spring-config.xml").getPath());
		
		personRepo = context.getBean(PersonRepo.class);

	}
	
	@Test
	public void inserDocument() {

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
		logger.info("Person List : ");
		for (Person person : personList) {
			logger.info(person);
		}

		//search by name 
		personList = personRepo.searchByName("Hamza");

		for (Person person : personList) {
			logger.info(person);
		}

	}
	
	@After
	public void after() throws Exception {
		context.close();
	}
}
