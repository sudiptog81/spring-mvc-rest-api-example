package pro.ghosh.sudipto.springexample.dao;

import java.util.List;
import java.util.UUID;

import pro.ghosh.sudipto.springexample.model.Person;

public interface PersonDao {
	int deletePerson(UUID id);

	List<Person> getPeople();

	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return this.insertPerson(id, person);
	}

	int insertPerson(UUID id, Person person);

	int updatePerson(Person person);
}
