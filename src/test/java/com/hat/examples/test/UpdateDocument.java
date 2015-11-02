package com.hat.examples.test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hat.examples.person.entity.Person;

public class UpdateDocument {

	public final static Logger logger = Logger
			.getLogger(CriteriaSearchDocument.class);

	private ClassPathXmlApplicationContext context;

	private MongoOperations mongo;

	@Before
	public void before() throws Exception {

		context = new ClassPathXmlApplicationContext(new ClassPathResource(
				"spring-config.xml").getPath());

		mongo = (MongoOperations) context.getBean("mongoTemplate");

	}

	@Test
	public void updateDocument(){
		//query
		Query query = new Query();
		query.addCriteria(Criteria.where("cars.brand").is("BMW"));

		// Update
		Update update = new Update();
		update.set("name", "hamza");
		mongo.updateFirst(query, update, Person.class);

		// find : Criteria.where("cars.brand").is("BMW")
		Iterable<Person> personList = mongo.find(query, Person.class);

		for (Person person : personList) {
			logger.info(person);
		}

	}
	
	@After
	public void after() throws Exception {
		context.close();
	}
}
