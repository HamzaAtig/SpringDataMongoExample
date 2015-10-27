package com.hat.examples.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hat.examples.entity.Person;

public class UpdateDocument {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new ClassPathResource("spring-config.xml").getPath());
		MongoOperations mongo = (MongoOperations) context
				.getBean("mongoTemplate");

		Query query = new Query();
		query.addCriteria(Criteria.where("cars.brand").is("BMW"));

		// Update
		Update update = new Update();
		update.set("name", "hamza");
		mongo.updateFirst(query, update, Person.class);

		// find : Criteria.where("cars.brand").is("BMW")
		Iterable<Person> personList = mongo.find(query, Person.class);

		for (Person person : personList) {
			System.out.println(person);
		}

		context.close();

	}
}
