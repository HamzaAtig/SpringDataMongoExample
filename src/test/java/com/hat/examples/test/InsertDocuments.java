package com.hat.examples.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.hat.examples.person.entity.Person;
import com.hat.examples.repo.PersonRepo;
import com.hat.examples.utils.DataCreator;

public class InsertDocuments {

	public final static Logger logger = Logger.getLogger(InsertDocuments.class);

	private ClassPathXmlApplicationContext context;

	private PersonRepo personRepo;

	private DataCreator dataCreator;

	@Before
	public void before() throws Exception {

		context = new ClassPathXmlApplicationContext(new ClassPathResource(
				"spring-config.xml").getPath());

		personRepo = context.getBean(PersonRepo.class);

		dataCreator = context.getBean(DataCreator.class);

	}

	@Test
	public void inserDocument() {

		List<Person> persons = dataCreator.getPersons(100);
		for (Person person : persons) {
			personRepo.save(person);
		}

		// findAll person
		Iterable<Person> personList = personRepo.findAll();
		logger.info("Person List : ");
		for (Person person : personList) {
			logger.info(person);
		}

		// search by name
		personList = personRepo.searchByName("Monica");

		for (Person person : personList) {
			logger.info(person);
		}

	}

	@After
	public void after() throws Exception {
		context.close();
	}
}
