package com.hat.examples.test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.hat.examples.entity.Person;
import com.hat.examples.repo.PersonRepo;

public class RepositorySearchDocument {
	
public final static Logger logger = Logger.getLogger(RepositorySearchDocument.class);
	
	private ClassPathXmlApplicationContext context ;
	
	private PersonRepo personRepo; 
	
	@Before
	public void before() throws Exception {
	
		context = new ClassPathXmlApplicationContext(
				new ClassPathResource("spring-config.xml").getPath());
		
		personRepo = context.getBean(PersonRepo.class);

	}
	
	@Test
	public  void searchDocument() {
	
		Iterable<Person> personList = personRepo.searchByStateName("London");

		for (Person person : personList) {
			System.out.println(person);
		}
		
		personList = personRepo.searchByName("Hamza");
		for (Person person : personList) {
			System.out.println(person);
		}
		
	}
	
	@After
	public void after() throws Exception {
		context.close();
	}
}
