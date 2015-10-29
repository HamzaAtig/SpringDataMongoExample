package com.hat.examples.test;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hat.examples.entity.Person;

public class CriteriaSearchDocument {
	
	public final static Logger logger = Logger.getLogger(CriteriaSearchDocument.class);
	
	private ClassPathXmlApplicationContext context ;
	
	private MongoOperations mongo ;
	
	@Before
	public void before() throws Exception {
	
		context = new ClassPathXmlApplicationContext(
				new ClassPathResource("spring-config.xml").getPath());
		
		mongo = (MongoOperations) context
				.getBean("mongoTemplate");

	}
	
	@Test
	public void searchDocument() {
		
		ArrayList<Integer> ageList = new ArrayList<Integer>();
		ageList.add(28);
		ageList.add(50);
		Query query = new Query();
		query.addCriteria(Criteria.where("age").in(ageList));
		Iterable<Person> personList = mongo.find(query, Person.class);

		Long ageCount = mongo.count(query, Person.class);
		logger.info("ageCount : " + ageCount);

		for (Person person : personList) {
			logger.info(person.toString());
		}

	}
	
	@After
	public void after() throws Exception {
		context.close();
	}
}
