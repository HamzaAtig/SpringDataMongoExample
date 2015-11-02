package com.hat.examples.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hat.examples.person.entity.Address;
import com.hat.examples.person.entity.Car;
import com.hat.examples.person.entity.Person;
import com.hat.examples.seq.SequenceDao;

@Component
public class DataCreator {

	/*  Person Data */
	public static String[] names =new String[] {"Jone","Michael","Jane","Piter","Monica"};
	
	public static int[] ages =new int[] {18,20,22,25,30,35,37,40};
	
	public static String[] addresses = new String[] {"18 rue ","20 rue ","25 rue  "," 30 rue ","35 rue","40 rue "};
	
	public static String[] cities  = new String[] {"Londre","Paris","Munic","Toulouse","Nice","Amesterdam"};

	public static String[] states  = new String[] {"France","England","German","NetherLands"};
	
	public static String[] brands = new String[] {"BMW","Audit","Peugeot","Mercedes"};

	public static String[] serials = new String[] {"aaa1225aaa","bbb2558bbbb","ccccc558552cccc","qqqq4778787qqqq","oooo578451oooo"};

	public static String[] colors = new String[] {"yellow","green","red","black","white"};
	
	public static long[]  zipcodes = new long[] {75015l,80869l,978800l,12500l,64100l};
	
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
		Random random = new Random();
		for (int i = 0; i < number; i++) {
			int nameRand = random.nextInt(names.length);
			int ageRand = random.nextInt(ages.length);
			int addressRand = random.nextInt(addresses.length);
			int cityRand = random.nextInt(cities.length);
			int stateRand = random.nextInt(states.length);
			int brandRand = random.nextInt(brands.length);
			int serialRand = random.nextInt(serials.length);
			int colorRand = random.nextInt(colors.length);
			int zipcodeRand = random.nextInt(zipcodes.length);
			Car car = new Car(brands[brandRand], serials[serialRand], colors[colorRand]);
			car.setCarId(sequenceDao.getNextSequenceId(CAR_SEQ_KEY));
			List<Car> cars = Arrays.asList(new Car[]{car});
			Address address = new Address(addresses[addressRand], cities[cityRand], states[stateRand], zipcodes[zipcodeRand]);
			address.setAddressId(sequenceDao.getNextSequenceId(ADDRESS_SEQ_KEY));
			List<Address> addresses = Arrays.asList(new Address[]{address});
			Person person = new Person(names[nameRand], ages[ageRand], addresses, cars);
			person.setPersonId(sequenceDao.getNextSequenceId(PERSON_SEQ_KEY));
			persons.add(person);
		}
		return persons;
	}
	
}
