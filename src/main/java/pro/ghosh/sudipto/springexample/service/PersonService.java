package pro.ghosh.sudipto.springexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pro.ghosh.sudipto.springexample.dao.PersonDao;
import pro.ghosh.sudipto.springexample.model.Person;

@Service
public class PersonService {
	private final PersonDao personDao;

	@Autowired
	public PersonService(@Qualifier("FakeDao") PersonDao personDao) {
		super();
		this.personDao = personDao;
	}

	public int addPerson(Person person) {
		return this.personDao.insertPerson(person);
	}

	public int deletePerson(Person person) {
		return this.personDao.deletePerson(person.getId());
	}

	public List<Person> getPeople() {
		return this.personDao.getPeople();
	}

	public int updatePerson(Person person) {
		return  this.personDao.updatePerson(person);
	}
}
