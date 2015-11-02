package com.hat.examples.test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;

import com.hat.examples.models.ValueObject;

public class MapReduce {

	public final static Logger logger = Logger.getLogger(MapReduce.class);

	private ClassPathXmlApplicationContext context;

	private MongoOperations mongo;

	@Before
	public void before() throws Exception {

		context = new ClassPathXmlApplicationContext(new ClassPathResource(
				"spring-config.xml").getPath());

		mongo = (MongoOperations) context.getBean("mongoTemplate");

	}

	@Test
	public void MapReduceTest() {

		MapReduceResults<ValueObject> results = mongo.mapReduce("person",
				"classpath:mapPerson.js", "classpath:reducePerson.js",
				ValueObject.class);

		for (ValueObject val : results) {
			System.out.println(val);
		}
	}

	@After
	public void after() throws Exception {
		context.close();
	}
}
