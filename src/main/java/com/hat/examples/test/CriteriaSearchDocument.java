package com.hat.examples.test;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hat.examples.entity.Person;

public class CriteriaSearchDocument {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new ClassPathResource("spring-config.xml").getPath());
		MongoOperations mongo = (MongoOperations) context
				.getBean("mongoTemplate");

		ArrayList<Integer> ageList = new ArrayList<Integer>();
		ageList.add(28);
		ageList.add(50);
		Query query = new Query();
		query.addCriteria(Criteria.where("age").in(ageList));
		Iterable<Person> personList = mongo.find(query, Person.class);

		Long ageCount = mongo.count(query, Person.class);
		System.out.println("ageCount : " + ageCount);

		for (Person person : personList) {
			System.out.println(person);
		}

		context.close();

	}
}
