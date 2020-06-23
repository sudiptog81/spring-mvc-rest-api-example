package pro.ghosh.sudipto.springexample.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pro.ghosh.sudipto.springexample.model.Person;
import pro.ghosh.sudipto.springexample.service.PersonService;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}

	@PostMapping
	public void addPerson(@RequestBody Person person) {
		this.personService.addPerson(person);
	}

	@PutMapping
	public void updatePerson(@RequestBody Person person) {
		this.personService.updatePerson(person);
	}

	@DeleteMapping
	public void deletePerson(@RequestBody Person person) {
		this.personService.deletePerson(person);
	}

	@GetMapping
	public List<Person> getPeople() {
		return this.personService.getPeople();
	}
}
