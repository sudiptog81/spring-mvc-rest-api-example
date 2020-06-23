package pro.ghosh.sudipto.springexample.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import pro.ghosh.sudipto.springexample.model.Person;

@Repository("FakeDao")
public class FakePersonDataAccessService implements PersonDao {
	private static List<Person> DB = new ArrayList<>();

	@Override
	public int deletePerson(UUID id) {
		for (int i = 0; i < DB.size(); i++) {
			if (DB.get(i).getId().equals(id)) {
				DB.remove(i);
			}
		}
		System.out.println("Removed: " + id);
		return 1;
	}

	@Override
	public List<Person> getPeople() {
		return DB;
	}

	@Override
	public int insertPerson(UUID id, Person person) {
		DB.add(new Person(id, person.getName()));
		System.out.println("Added: " + id);
		return 1;
	}

	@Override
	public int updatePerson(Person person) {
		for (int i = 0; i < DB.size(); i++) {
			if (DB.get(i).getId().equals(person.getId())) {
				DB.set(i, person);
			}
		}
		System.out.println("Updated: " + person.getId());
		return 1;
	}
}
