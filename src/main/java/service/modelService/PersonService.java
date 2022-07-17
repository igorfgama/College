package service.modelService;

import model.Person;
import repository.PersonRepository;
import service.validation.PersonValidation;

import java.util.Set;

public class PersonService {
    public Person getPersonInfo(String id, String password){
        Set<Person> people = new PersonRepository().getAll();
        return people.stream()
                .filter(p -> p.getId().equals(id) && p.getPassword(password))
                .findFirst()
                .get();
    }

    public void savePerson(Person person){
        new PersonValidation().validateItem(person);
        new PersonRepository().save(person);
        System.out.println("Usuário registrado.");
    }
}
