package com.hat.examples.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hat.examples.person.entity.Address;
import com.hat.examples.person.entity.Car;
import com.hat.examples.person.entity.Person;
import com.hat.examples.seq.SequenceDao;

@Component
public class DataCreator {

	/*  Person Data */
	public static List<String> names = Arrays.asList(new String[] {"Jone","Michael","Jane","Piter","Monica"});
	
	public static List<Integer> ages =Arrays.asList(new Integer[] {18,20,22,25,30,35,37,40});
	
	public static List<String> addresses =Arrays.asList(new String[] {"18 rue ","20 rue ","25 rue  "," 30 rue ","35 rue","40 rue "});
	
	public static List<String> cities  =Arrays.asList(new String[] {"Londre","Paris","Munic","Toulouse","Nice","Amesterdam"});

	public static List<String> states  =Arrays.asList(new String[] {"France","England","German","NetherLands"});
	
	public static List<String> brands =Arrays.asList(new String[] {"BMW","Audit","Peugeot","Mercedes"});

	public static List<String> serials =Arrays.asList(new String[] {"aaa1225aaa","bbb2558bbbb","ccccc558552cccc","qqqq4778787qqqq","oooo578451oooo"});

	public static List<String> colors =Arrays.asList(new String[] {"yellow","green","red","black","white"});
	
	public static List<Long>  zipcodes = Arrays.asList(new Long[] {75015l,80869l,978800l,12500l,64100l});
	
	private static final String CAR_SEQ_KEY = "car";

	private static final String ADDRESS_SEQ_KEY = "address";

	private static final String PERSON_SEQ_KEY = "person";
	
	/*  Sejour Data */
	private static final String HOTEL_SEQ_KEY = "hotel";

	private static final String SEJOUR_SEQ_KEY = "sejour";

	private static final String VOL_SEQ_KEY = "vol";
	
	private static final String AGENCE_SEQ_KEY = "agence";
	
	@Autowired
	private SequenceDao sequenceDao;
	
	public List<Person> getPersons(Integer number){
		List<Person> persons = new ArrayList<Person>(); 
		
		for (int i = 0; i < number; i++) {
			Car car = new Car(getElementFromList(brands), getElementFromList(serials), getElementFromList(colors));
			car.setCarId(sequenceDao.getNextSequenceId(CAR_SEQ_KEY));
			List<Car> cars = Arrays.asList(new Car[]{car});
			Address address = new Address(getElementFromList(addresses), getElementFromList(cities), getElementFromList(states), getElementFromList(zipcodes));
			address.setAddressId(sequenceDao.getNextSequenceId(ADDRESS_SEQ_KEY));
			List<Address> addresses = Arrays.asList(new Address[]{address});
			Person person = new Person(getElementFromList(names), getElementFromList(ages), addresses, cars);
			person.setPersonId(sequenceDao.getNextSequenceId(PERSON_SEQ_KEY));
			persons.add(person);
		}
		return persons;
	}
	
	private static <T>  T getElementFromList(List<T> elements){
		Random random = new Random();
		if(!CollectionUtils.isEmpty(elements) ){
			int index =  random.nextInt(elements.size());
			return elements.get(index);
		}else{
			return null ; 
		}
	}
	
}
