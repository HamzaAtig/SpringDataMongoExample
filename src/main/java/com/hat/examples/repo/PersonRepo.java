package com.hat.examples.repo;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hat.examples.entity.Person;

public interface PersonRepo extends CrudRepository<Person, Long>
{
		@Query("{'name' : ?0}")
		public Iterable<Person> searchByName(String personName);
		
		@Query("{'addresses.state' : ?0}")
		public Iterable<Person> searchByStateName(String state);

		
}
